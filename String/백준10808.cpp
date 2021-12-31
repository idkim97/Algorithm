#include <iostream>
#include <vector>
#include <stack>

using namespace std;
using std::endl;
using std::cout;
using std::cin;

int main() {
	
	vector <int> v(26);

	string str;
	cin >> str;

	for (int i = 0; i < str.length(); i++) {
		int temp = str[i] - 'a';
		v[temp]++;
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}

	return 0;
}