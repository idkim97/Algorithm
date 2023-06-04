#include <iostream>
#include <algorithm>

using namespace std;

int d[501][501];
int a[501][501];

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int test;
	cin >> test;

	for (int i = 1; i <= test; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> a[i][j];
		}
	}
	d[1][1] = a[1][1];
	d[1][0] = 0;

	for (int i = 2; i <= test; i++) {
		for (int j = 1; j <= i; j++) {
			d[i][j] = max({ d[i - 1][j-1] + a[i][j], d[i - 1][j] + a[i][j] });
		}
	}

	int res = 0;
	for (int i = 1; i <= test; i++) {
		res = max(d[test][i], res);
	}

	cout << res << endl;

}