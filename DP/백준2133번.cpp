#include <iostream>

using namespace std;

int d[30];


int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	d[0] = 1;
	d[1] = 0;
	d[2] = 3;
	d[3] = 0;

	for (int i = 4; i <= num; i++) {
		d[i] = 3 * d[i - 2];
		for (int j = 4; j <= i; j += 2) {
			d[i] += 2 * d[i - j];
		}
	}

	cout << d[num] << endl;


}