#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
vector<int> v;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    for (int num : v) {
        cout << num << '\n';
    }

    return 0;
}
