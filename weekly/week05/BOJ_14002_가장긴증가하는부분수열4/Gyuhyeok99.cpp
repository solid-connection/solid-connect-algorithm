#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int t, n, ret;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> t;
    while (t--) {
        cin >> n;
        vector<pair<int, int>> scores;
        ret = 1;
        for (int i = 0; i < n; i++) {
            int a, b;
            cin >> a >> b;
            scores.push_back({a, b});
        }
        sort(scores.begin(), scores.end());

        int _max = scores[0].second;
        for (int i = 1; i < n; i++) {
            if (scores[i].second <= _max) {
                _max = scores[i].second;
                ret++;
            }
        }
        cout << ret << '\n';
    }
    return 0;
}
