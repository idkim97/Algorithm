#include <iostream>

using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;  // 정수의 개수
	int s;	// 정수
	cin >> n >> s;

	int a[30];
	int ans = 0;

	for (int i = 0; i < n; i++) cin >> a[i];

	for (int i = 1; i < (1 << n); i++) {
		int sum = 0;
		for (int k = 0; k < n; k++) {
			if (i & (1 << k)) sum += a[k];
		}
		if (sum == s) ans += 1;
	}

	cout << ans << "\n";
}