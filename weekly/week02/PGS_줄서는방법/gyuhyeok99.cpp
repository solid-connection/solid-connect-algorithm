#include <string>
#include <vector>
using namespace std;

vector<int> answer;
vector<int> numbers;
vector<long long> dp;

vector<int> solution(int n, long long k) {
    dp.resize(n);
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
        dp[i] = dp[i-1] * i;
    }

    for (int i = 1; i <= n; i++) {
        numbers.push_back(i);
    }

    k--;

    for (int i = 0; i < n; i++) {
        long long idx = k / dp[n-1-i];
        answer.push_back(numbers[idx]);
        numbers.erase(numbers.begin() + idx);
        k %= dp[n-1-i];
    }

    return answer;
}
