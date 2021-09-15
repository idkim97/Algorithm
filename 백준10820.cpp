#include <iostream>
#include <string>

using namespace std;
using std::endl;
using std::cout;
using std::cin;

int main() {

	string str;

	while (getline(cin, str)) {

		int space = 0;
		int num = 0;
		int big = 0;
		int small = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str[i] == ' ') space++;
			else if (str[i] >= 'a' && str[i] <= 'z') small++;
			else if (str[i] >= 'A' && str[i] <= 'Z') big++;
			else if (str[i] >= '0' && str[i] <= '9') num++;
		}

		cout << small << " " << big << " " << num << " " << space << endl;

	}

	return 0;
}