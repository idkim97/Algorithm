#include <iostream>
#include <algorithm>
using namespace std;

bool c[10]; // 숫자를 사용했는지 안했는지 확인하는 배열
int a[10]; // 숫자가 담긴 배열

void go(int index, int n, int m) {
	if (index == m) {
		for (int i = 0; i < m; i++) {
			cout << a[i];
			if (i != m - 1) cout << " ";
		}

		cout << '\n';
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (c[i]) continue;  //c[i]가 true, 즉 사용됐으면 continue
		c[i] = true;
		a[index] = i;
		go(index + 1, n, m);
		c[i] = false;
	}
}

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;
	go(0, n, m);
	return 0;`

}