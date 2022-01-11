#include <iostream>

using namespace std;

int a[1001];
int d[1001];


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	for (int i = 1; i <= num; i++) cin >> a[i];

	int max = 0;
	d[0] = 0;
	a[0] = 0;
	for (int i = 1; i <= num; i++) {
		for (int j = 0; j < i; j++) {
			if (a[i] > a[j] && d[i] < d[j] + a[i]) {
				d[i] = d[j] + a[i];
			}

			if (d[i] > max) max = d[i];
		}

	}

	cout << max << endl;
}