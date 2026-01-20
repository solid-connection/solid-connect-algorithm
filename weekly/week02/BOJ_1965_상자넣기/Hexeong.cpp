//
// Created by hex on 26. 1. 19..
//

#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n; cin >> n;
    vector<int> arr(n);
    vector<int> dp(n, 1);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    int max_v = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        max_v = max(max_v, dp[i]);
    }

    cout << max_v << endl;

    return 0;
}