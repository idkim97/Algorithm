#include <iostream>
using namespace std;

int d[1001]; // a[i]�� ���������� �ϴ� ���� �� �κм����� ����
int a[1001]; // ���� a[i]

int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;
	

	for (int i = 0; i < num; i++) cin >> a[i];

	for (int i = 0; i < num; i++) {
		d[i] = 1;
		for (int j = 0; j < i; j++) {
			if ((a[j] < a[i]) && d[i] < d[j] + 1) {
				d[i] = d[j] + 1;
			}
		}
	}
	int max = d[0];

	for (int i = 0; i < num; i++) {
		if (d[i] > max) max = d[i];

	}
	cout << max << endl;
}