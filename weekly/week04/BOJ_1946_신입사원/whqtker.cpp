#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	int T;
	cin >> T;
	while (T--) {
		int n;
		cin >> n;

		vector<pair<int, int>> v;
		for (int i = 0; i < n; i++) {
			int a, b;
			cin >> a >> b;
			v.push_back({ a,b });
		}

		sort(v.begin(), v.end());

		int cnt = 0; // 탈락한 애들 수

		// 비교 원소 조건
		// 이전보다 first가 클 것 (항상 만족)
		// 이전보다 second가 작을 것
		int cmpA = v[0].first;
		int cmpB = v[0].second;
		for (int i = 1; i < v.size(); i++) {
			int curA = v[i].first;
			int curB = v[i].second;

			if (curA > cmpA && curB > cmpB) {
				cnt++;
			}
			// 비교 원소 업데이트
			else {
				if (curB < cmpB) {
					cmpA = curA;
					cmpB = curB;
				}
			}
		}

		cout << n - cnt << "\n";
	}
}