#include <iostream>
#include <deque>

using namespace std;
using std::cin;
using std::cout;
using std::endl;

int main() {

	int num;
	cin >> num;
	deque <int> dq;
	string str;

	while (num--) {
		int temp;
		cin >> str;
		if (str == "push_front") {
			cin >> temp;
			dq.push_front(temp);
		}
		else if (str == "push_back") {
			cin >> temp;
			dq.push_back(temp);
		}
		else if (str == "pop_front") {
			if (dq.empty()) cout << "-1" << endl;
			else {
				cout << dq.front() << endl;
				dq.pop_front();
			}
		}
		else if (str == "pop_back") {
			if (dq.empty()) cout << "-1" << endl;
			else {
				cout << dq.back() << endl;
				dq.pop_back();
			}
		}
		else if (str == "size") {
			cout << dq.size() << endl;
		}
		else if (str == "empty") {
			if (dq.empty()) cout << "1" << endl;
			else cout << "0" << endl;
		}
		else if (str == "front") {
			if (dq.empty()) cout << "-1" << endl;
			else cout << dq.front() << endl;
		}
		else if (str == "back") {
			if (dq.empty()) cout << "-1" << endl;
			else cout << dq.back() << endl;
		}
	}
	return 0;
}
