#include <iostream>

using namespace std;

int n, m, ret;
int arr[1001][1001], dp[1001][1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> m >> n;

    for (int i = 1; i <= m; i++) {
        for (int j= 1; j <= n; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (!arr[i][j]) {
                if (!dp[i - 1][j - 1] || !dp[i][j - 1] || !dp[i - 1][j]) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = min(min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
                ret = max(ret, dp[i][j]);
            }
        }
    }

    cout << ret << '\n';

    return 0;
}
