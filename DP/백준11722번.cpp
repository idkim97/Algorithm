#include <iostream>
#include <algorithm>

using namespace std;

int a[1001]; // ����
int d[1001]; // ���� �� �����ϴ� �κ� ������ ����

int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	for (int i = 1; i <= num; i++) cin >> a[i];

	d[0] = 0;
	int max = 0;

	
	for (int i = 1; i <= num; i++) {
		d[i] = 1;
		for (int j = 1; j <= i; j++) {
			if (a[i] < a[j] && d[i] < d[j] + 1) {
				d[i] = d[j] + 1;
			}
			if (max < d[i]) max = d[i];
		}
	}

	cout << max << endl;
}