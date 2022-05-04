#include <iostream>
#include <algorithm>

using namespace std;
bool broken[10];

int check(int n) {
	int len = 0;

	if (n == 0) {
		if (broken[0]) return 0;
		else return 1;
	}
	while (n > 0) {
		if (broken[n % 10])
			return 0;

		len += 1;
		n /= 10;
	}

	return len;
}

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	int m;
	cin >> m;


	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		broken[x] = true;
	}

	int ans = num - 100; // 초기값설정
	if (ans < 0) ans = -ans;

	for (int i = 0; i <= 1000000; i++) {
		int c = i;
		int len = check(c);
		if (len > 0) {
			int press = c - num;
			if (press < 0) press = -press;
			if (ans > len + press) ans = len + press;
		}
	}

	cout << ans << endl;
	return 0;
}