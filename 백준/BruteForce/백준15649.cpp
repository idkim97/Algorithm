#include <iostream>
#include <algorithm>
using namespace std;

bool c[10]; // ���ڸ� ����ߴ��� ���ߴ��� Ȯ���ϴ� �迭
int a[10]; // ���ڰ� ��� �迭

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
		if (c[i]) continue;  //c[i]�� true, �� �������� continue
		c[i] = true;
		a[index] = i;
		go(index + 1, n, m);
		c[i] = false;
	}
}

int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;
	go(0, n, m);
	return 0;`

}