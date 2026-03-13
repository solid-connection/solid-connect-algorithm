#include <iostream>
#include <algorithm>

using namespace std;

int dp[1500051];
pair<int, int> consult[1500001]; // consult[i] = { x, y } : i일의 상담은 x일이 걸리며 수익은 y

int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int x, y;
		cin >> x >> y;
		consult[i] = { x, y };
	}

    for (int i = 1; i <= n; i++) {
        dp[i + 1] = max(dp[i + 1], dp[i]);

        if (i + consult[i].first <= n + 1) {
            dp[i + consult[i].first] = max(dp[i + consult[i].first], dp[i] + consult[i].second);
        }
    }

    cout << dp[n + 1] << "\n";
}