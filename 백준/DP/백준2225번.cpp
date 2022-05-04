#include <iostream>
using namespace std;

long long int d[201][201]; // d[k][n] -> 정수k개를 더해서 합이 N이 되는 경우의수


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	const long long int temp = 1000000000LL;

	int n;
	cin >> n;

	int k;
	cin >> k;

	d[0][0] = 1;

	for (int i = 1; i <= k; i++) {
		for (int j = 0; j <= n; j++) {
			for (int p = 0; p <= j; p++) {
				d[i][j] += d[i - 1][j - p];
				d[i][j] %= temp;
			}
		}
	}

	int res = d[k][n] % temp;
	cout << res << endl;


}