#include <iostream>
#include <stack>

using namespace std;

stack<int> s;
int n;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for(int i = 0; i < n; i++) {
        string cmd;
        int x;
        cin >> cmd;

        if (cmd == "push") {
            cin >> x;
            s.push(x);
        }
        else if (cmd == "pop") {

            if (s.empty()) {
                cout << -1 << endl;
            }

            else {
                cout << s.top() << endl;
                s.pop();
            }
        }
        else if(cmd == "size") {
            cout << s.size() << endl;
        }
        else if(cmd == "empty") {
            if(s.empty()) {
                cout << 1 << endl;
            }else {
                cout << 0 << endl;
            }
        }
        else if(cmd == "top") {
            if(s.empty()) {
                cout << -1 << endl;
            }
            else {
                cout << s.top() << endl;
            }
        }
    }
    return 0;
}
