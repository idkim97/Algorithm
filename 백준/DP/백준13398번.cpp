#include <iostream>
#include <algorithm>

using namespace std;
int d1[100001]; // i�� �����ϴ� ������
int d2[100001]; // i�� ������ ������
int a[100001];


int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int test;
	cin >> test;

	for (int i = 0; i < test; i++) cin >> a[i];


	for (int i = 0; i < test; i++) {
		d1[i] = a[i];
		if (i == 0) continue;
		d1[i] = max(d1[i - 1] + a[i], a[i]);
	}

	for (int i = test-1; i >=0 ; i--) {
		d2[i] = a[i];
		if (i == test - 1) continue;
		d2[i] = max(d2[i+1]+a[i],a[i]);
	}

	int res = d1[0];

	for (int i = 1; i < test; i++) {
		if (res < d1[i]) res = d1[i];
	}

	for (int i = 1; i < test-1; i++) {
		
		if (res < d1[i - 1] + d2[i + 1]) res = d1[i - 1] + d2[i + 1];
	}

	cout << res << endl;



}