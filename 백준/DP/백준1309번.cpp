#include <iostream>

using namespace std;

int d[100001][3];


int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	d[1][0] = 1;
	d[1][1] = 1;
	d[1][2] = 1;

	for (int i = 2; i <= num; i++) {
		d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % 9901;
		d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
		d[i][2] = (d[i - 1][0] + d[i - 1][1]) % 9901;
	}

	int res = (d[num][0] + d[num][1] + d[num][2]) % 9901;

	cout << res << endl;


}