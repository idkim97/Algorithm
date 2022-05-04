#include <iostream>
#include <vector>

using namespace std;
const int inf = -100000000;

int t[21];	// ����ϴµ� �ɸ��� �ð�
int p[21];	// ����ϴµ� �޴� ���
int ans = 0;
int n;

void go(int day, int sum) {

	if (day == n + 1) {
		if (ans < sum) ans = sum;
		return;
	}

	if (day > n + 1) return;

	go(day + 1, sum);
	go(day + t[day], sum + p[day]);

}

int main() {

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> t[i];
		cin >> p[i];
		
	}

	go(1, 0);
	cout << ans << endl;
	return 0;

}