#include <iostream>
#include <string>
#include <stack>
#include <queue>

using namespace std;
using std::endl;
using std::cout;
using std::cin;

int main() {
	string str;
	getline(cin, str);
	str += ' ';
	int j = 0;

	stack <char> st;
	queue <char> qu;


	for (int i = 0; i < str.size(); i++) {
		if (str[i] == ' ') {
			while (!st.empty()) {
				cout << st.top();
				st.pop();
			}
			cout << " ";
		}
		else if (str[i] == '<') {
			if (!st.empty()) {
				while (!st.empty()) {
					cout << st.top();
					st.pop();
				}
			}
			j = i;
			while (1) {
				if (str[j] == '>') {
					while (!qu.empty()) {
						cout << qu.front();
						qu.pop();
					}
					cout << ">";
					i = j;
					break;
				}
				else {
					qu.push(str[j]);
					j++;
				}
				
			}
		}
		else {
			st.push(str[i]);
		}
	}

	return 0;
}