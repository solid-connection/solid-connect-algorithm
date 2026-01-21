#include <iostream>
#include <algorithm>

using namespace std;

int n, ret;
int arr[1500001][2];
int dp[1500001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i][0] >> arr[i][1];
    }

    for (int i = n - 1; i >= 0; i--) {
        if (i + arr[i][0] <= n) {
            dp[i] = max(dp[i + 1], arr[i][1] + dp[i + arr[i][0]]);
        } else {
            dp[i] = dp[i + 1];
        }
    }

    cout << dp[0] << '\n';
    return 0;
}
