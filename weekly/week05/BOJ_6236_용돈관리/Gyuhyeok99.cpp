#include <iostream>
#include <algorithm>

using namespace std;

int n, m, l, r, ret = 987654321;
int arr[100001];

bool check(int mid) {
    int cnt = 1;
    int sum = 0;
    for(int i = 0; i < n; i++) {
        if(sum + arr[i] > mid) {
            cnt++;
            sum = 0;
        }
        sum += arr[i];
    }
    return cnt <= m;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        r += arr[i];
        l = max(l, arr[i]);
    }

    while(l <= r) {
        int mid = (l + r) / 2;
        if(check(mid)) {
            ret = mid;
            r = mid - 1;
        }
        else {
            l = mid + 1;
        }
    }
    cout << ret << '\n';
    return 0;
}