#include <iostream>
#include <algorithm>

using namespace std;

int a[1001]; // 수열
int d1[1001]; // 증가하는 가장 긴 수열의 길이
int d2[1001]; // 감소하는 가장 긴 수열의 길이


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	int max1 = 0;
	int max2 = 0;

	for (int i = 1; i <= num; i++) cin >> a[i];

	// 증가하는 가장 긴 수열의 길이
	for (int i = 1; i <= num; i++) {
		d1[i] = 1;
		for (int j = 1; j <= i; j++) {
			if (a[i] > a[j] && d1[i] < d1[j] + 1) {
				d1[i] = d1[j] + 1;
			}
		}
	}

	// 감소하는 가장 긴 수열의 길이
	for (int i = num; i >= 1; i--) {
		d2[i] = 1;
		for (int j = i; j <= num; j++) {
			if (a[i] > a[j] && d2[i] < d2[j] + 1) {
				d2[i] = d2[j] + 1;
			}
		}
	}

	int res = 0;
	for (int i = 1; i <= num; i++) {
		if (res < d1[i] + d2[i] - 1) res = d1[i] + d2[i] - 1;
	}

	cout << res << endl;


}