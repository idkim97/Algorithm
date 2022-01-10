#include <iostream>
#include <algorithm>

using namespace std;

long long int d[10001]; // 1~i까지의 포도주를 마시는 최대값
int a[10001]; // 포도주의 양

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) cin >> a[i];

	d[0] = 0;
	d[1] = a[1];
	d[2] = a[1] + a[2];
	for (int i = 3; i <= n; i++) {
		d[i] = max({ d[i - 3] + a[i - 1] + a[i], d[i - 2] + a[i],d[i - 1] });
	}

	
	cout << d[n] << endl;

}