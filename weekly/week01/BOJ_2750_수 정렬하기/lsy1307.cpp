#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N, num;
    cin >> N;
    vector<int> numbers(N);
    for(int i {0}; i < N; i++) {
        cin >> num;
        numbers[i] = num;
    }
    sort(numbers.begin(), numbers.end());
    for(auto& data : numbers) cout << data << "\n";
}