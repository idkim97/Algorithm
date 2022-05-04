#include <iostream>
#include <algorithm>
using namespace std;

int d[1001][3];
int a[1001][3];


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	int res = 1000 * 1000 + 1;

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> a[i][j];
		}
	}
	d[0][0] = 0;
	d[0][1] = 0;
	d[0][2] = 0;

	for (int k = 0; k < 3; k++) {

		for (int i = 0; i < 3; i++) {
			if (i == k) d[1][i] = a[1][i];
			else d[1][i] = 1000 * 1000 + 1;
		}
		for (int i = 2; i <= n; i++) {
			d[i][0] = min(d[i - 1][1] + a[i][0], d[i - 1][2] + a[i][0]);
			d[i][1] = min(d[i - 1][0] + a[i][1], d[i - 1][2] + a[i][1]);
			d[i][2] = min(d[i - 1][0] + a[i][2], d[i - 1][1] + a[i][2]);
		}

		for (int i = 0; i < 3; i++) {
			if (i == k) continue;
			res = min(res, d[n][i]);
		}
	}


	cout << res << endl;


}