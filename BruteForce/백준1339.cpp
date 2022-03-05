#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

char arr[10][10];
int alpha[26];
int len[10];

bool desc(int a, int  b) {
	return a > b;
}

int main() {

	int res = 0;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		len[i] = strlen(arr[i]);
	}

	for (int i = 0; i < n; i++) {
		int pow = 1;
		for (int j = len[i] - 1; j >= 0; j--) {
			int temp = arr[i][j] - 'A';
			alpha[temp] += pow;
			pow *= 10;
		}
	}

	sort(alpha, alpha + 26,desc);

	for (int i = 0; i < 10; i++) {
		res += alpha[i] * (9 - i);
	}

	cout << res << endl;

	return 0;
}