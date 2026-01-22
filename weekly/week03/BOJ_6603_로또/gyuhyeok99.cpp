#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int k;
vector<int> v;

void combi(int start, vector<int> b) {
    if (b.size() == 6) {
        for (int i = 0; i < 6; i++) {
            cout << v[b[i]] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = start + 1; i < v.size(); i++) {
        b.push_back(i);
        combi(i, b);
        b.pop_back();
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true) {
        v.clear();
        cin >> k;
        if (k == 0) {
            break;
        }

        for (int i = 0; i < k; i++) {
            int num;
            cin >> num;
            v.push_back(num);
        }
        combi(-1, {});
        cout << '\n';
    }

    return 0;
}
