#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Stack {
public:
    void push(int X) {
        stack.push_back(X);
    }
    void pop() {
        if (stack.empty()) cout << -1 << "\n";
        else {
            cout << stack[stack.size() - 1] << "\n";
            stack.erase(stack.end() - 1);
        }
    }
    void size() {
        cout << stack.size() << "\n";
    }
    void empty() {
        cout << stack.empty() << "\n";
    }
    void top() {
        if (stack.empty()) cout << -1 << "\n";
        else {
            cout << stack[stack.size() - 1] << "\n";
        }
    }
private:
      vector<int> stack;
};

int main() {
    int N, X;
    string s;
    cin >> N;
    Stack stack;
    while (N--) {
        cin >> s;
        if (s == "push") {
            cin >> X;
            stack.push(X);
        }
        else if (s == "pop") {
            stack.pop();
        }
        else if (s == "size") {
            stack.size();
        }
        else if (s == "empty") {
            stack.empty();
        }
        else if (s == "top") {
            stack.top();
        }
    }
}