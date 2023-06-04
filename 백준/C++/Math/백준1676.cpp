#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
using std::endl;
using std::cout;
using std::cin;

int main() {
	
	int num;
	cin >> num;

	int count = 0;
	for (int i = 5; i <= num; i *= 5) {
		count += num / i;
	}

	cout << count << endl;
	return 0;
}