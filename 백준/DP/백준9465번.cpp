#include <iostream>
#include <algorithm>
using namespace std;

int d[100001][3]; // 2xi 스티커중 마지막이 j인 스티커뽑기의 최대값
int a[100001][3]; // 2xi 스티커의 점수

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int test;
	cin >> test;

	while (test--) {
		int num;
		cin >> num;
		for (int i = 1; i <= num; i++) cin >> a[i][0];
		for (int i = 1; i <= num; i++) cin >> a[i][1];

		d[0][0] = 0;
		d[0][1] = 0;
		d[0][2] = 0;

		for (int i = 1; i <= num; i++) {
			d[i][0] = max({ d[i - 1][0],d[i - 1][1], d[i - 1][2] });
			d[i][1] = max(d[i - 1][2], d[i - 1][0]) + a[i][0];
			d[i][2] = max(d[i - 1][0], d[i - 1][1]) + a[i][1];
		}

		int res = max({ d[num][0], d[num][1], d[num][2] });
		cout << res << endl;
	}

}