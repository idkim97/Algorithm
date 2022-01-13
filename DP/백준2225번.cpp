#include <iostream>
using namespace std;

long long int d[201][201]; // d[k][n] -> ����k���� ���ؼ� ���� N�� �Ǵ� ����Ǽ�


int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
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