#include <iostream>
using namespace std;
long long int d[91][2]; // i�ڸ��̰� �������ڸ��� j�� ��ģ���� ����


int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	d[0][0] = 0;
	d[1][1] = 1;
	d[1][0] = 0;

	for (int i = 2; i <= num; i++) {
		d[i][0] = d[i - 1][0] + d[i - 1][1]; // �������ڸ��� 0�ΰ��
		d[i][1] = d[i - 1][0]; // ������ �ڸ��� 1�ΰ��
	}
	long long int res = d[num][0] + d[num][1];
	cout << res << endl;
}