#include <iostream>
#include <unordered_set>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int N, num1, M, num2;
    cin >> N;
    unordered_set<int> numbers;
    numbers.reserve(N);
    while (N--) {
        cin >> num1;
        numbers.insert(num1);
    }
    cin >> M;
    while (M--) {
        cin >> num2;
        if (numbers.find(num2) != numbers.end()) cout << 1 << "\n";
        else cout << 0 << "\n";
    }
}