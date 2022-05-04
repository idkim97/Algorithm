#include <iostream>
using namespace std;

int d[1001]; // a[i]를 마지막으로 하는 가장 긴 부분수열의 길이
int a[1001]; // 수열 a[i]

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
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