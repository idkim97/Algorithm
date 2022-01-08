#include <iostream>

using namespace std;

int d[1001][10]; // 길이가 i이고 맨마지막수가 j인 오르막의 수


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	for (int i = 0; i < 10; i++) d[1][i] = 1;

	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= 9; j++) {
			for (int k = 0; k <= j; k++) {
				d[i][j] += (d[i - 1][k]) % 10007;
			}
		}
	}

	int res = 0;

	for (int i = 0; i <= 9; i++) {
		res += (d[n][i] % 10007);
	}

	cout << res % 10007 << endl;

}