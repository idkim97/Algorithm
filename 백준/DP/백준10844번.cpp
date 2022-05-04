#include <iostream>
using namespace std;

long long int d[101][10]; // ���̰� i�̸鼭 �������ڸ��� j�� ��ܼ��� ����
const long long int mod = 1000000000LL;

int main() {
	int num;
	cin >> num;

	for (int i = 1; i <= 9; i++) d[1][i] = 1; // ���̰� 1�� ��ܼ�

	for (int i = 2; i <= num; i++) {
		for (int j = 0; j <= 9; j++) {
			d[i][j] = 0; // �迭 �ʱ�ȭ
			if (j == 0) d[i][j] = d[i - 1][j + 1]; // �������ڸ��� 0�϶� 
			else if (j == 9) d[i][j] = d[i - 1][j - 1]; // �������ڸ��� 9�϶�
			else d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]); // ������

			d[i][j] %= mod;
		}
	}

	long long int res = 0;
	for (int i = 0; i <= 9; i++) {
		res += d[num][i];
	}
	res %= mod;

	cout << res << endl;
}