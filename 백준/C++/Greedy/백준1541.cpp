#include <iostream>
#include <string>

using namespace std;

string str;
bool IsMinus = false;

int main() {
    cin >> str;
    int ans = 0;
    string temp;

    for (int i = 0; i <= str.size(); i++) {

        if (str[i] == '-' || str[i] == '+' || i == str.size()) {
            if (IsMinus) {
                ans -= stoi(temp);
                temp = "";
            }
            else {
                ans += stoi(temp);
                temp = "";
            }
        }
        else {
            temp += str[i];
        }
        if (str[i] == '-') IsMinus = true;
    }

    cout << ans << endl;
}