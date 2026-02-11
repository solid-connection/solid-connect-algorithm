#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int arr[100000];

// x원 인출하는 경우 m번 이하로 가능한가 ?
bool able(int x) {
	int target = x;
	int cnt = 1; // 인출 횟수, 처음 한 번 인출함

	for (int i = 0; i < n; i++) {
		target -= arr[i];

		// 인출 안해도 되는 상황
		if (target >= 0) {
			continue;
		}
		else {
			cnt++;
			target = x - arr[i];

			// 만약 인출했으나 현재 사용 불가능한 경우
			if (target < 0) {
				return false;
			}
		}
	}

	return cnt <= m;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);

	cin >> n >> m;

	int left = 0;
	int right = 0;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		right += arr[i];
	}

	int ans = 2e9;
	while (left <= right) {
		int mid = (left + right) / 2;

		// mid원으로 m번 이하로 인출 가능하다면 더 작은 금액 시도
		if (able(mid)) {
			ans = min(ans, mid);
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}

	cout << ans;
}