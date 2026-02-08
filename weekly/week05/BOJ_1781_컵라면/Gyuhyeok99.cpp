#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;
vector<pair<int, int>> v;
int n, p, d, ret;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> d >> p;
        v.push_back({d, p});
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < n; i++) {
        pq.push(v[i].second);
        if (v[i].first < pq.size()) {
            pq.pop();
        }
    }

    while (pq.size()) {
        ret += pq.top();
        pq.pop();
    }

    cout << ret << '\n';

    return 0;
}
