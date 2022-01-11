#include <iostream>
#include <algorithm>

using namespace std;

int a[1001]; // 수열
int d[1001]; // 가장 긴 감소하는 부분 수열의 길이

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
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