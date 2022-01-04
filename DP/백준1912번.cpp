#include <iostream>
#include <algorithm>
using namespace std;

int a[100001]; // 입력받은 수열
int d[100001]; // 연속된 몇개의수의 최대 합

int main() {
	int num;
	cin >> num;

	for (int i = 1; i <= num; i++) {
		cin >> a[i];
	}

	d[0] = 0;

	for (int i = 1; i <= num; i++) {
		d[i] = max(d[i - 1] + a[i], a[i]);
	}


	int res = d[1];
	for (int i = 1; i <= num; i++) {
		if (res < d[i]) res = d[i];
	}

	cout << res << endl;
}