#include <iostream>

using namespace std;
const long long int divide = 1000000009LL;
long long int d[1000001];

long long int func(int num) {
	d[num] = (d[num - 1] + d[num - 2] + d[num - 3]) % divide;
	d[num] %= divide;

	return d[num];
}

int main() {

	int test;
	cin >> test;

	int num;

	d[0] = 1;
	d[1] = 1;
	d[2] = 2;


	for (int i = 3; i <= 1000000; i++) {
		func(i);
	}

	for (int i = 0; i < test; i++) {
		cin >> num;
		long long int res = func(num);
		cout << res << endl;
	}



}