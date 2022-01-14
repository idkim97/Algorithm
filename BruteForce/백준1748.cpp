#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	long long n;
	cin >> n;

	long long count = 0;
	long long sum = 0;

	for (int i = 1; i <= 9; i++) {
		if (n / (int)pow(10, i) == 0) {
			count = i;
			//cout << count << endl;
			break;
		}
	}

	for (int i = 0; i <= count - 2; i++) {
		sum += 9 * pow(10, i) * (i + 1);
	}

	long long temp = n - pow(10, count - 1);

	sum += ((temp + 1) * count);

	cout << sum << endl;
}