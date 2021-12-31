#include <iostream>
#include <algorithm>
using namespace std;

int D[1001]; // N개를 구매하는데 필요한 최대 비용


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int test;
	cin >> test;
	int res = 0;

	int buy[10001]; // i개를 구매하는데 필요한 값
	D[0] = 0;
	buy[0] = 0;

	for (int i = 1; i <= test; i++) {
		cin >> buy[i];
	}

	for (int i = 1; i <= test; i++) {
		for (int j = 1; j <= i; j++) {
			D[i] = max(D[i], D[i - j] + buy[j]);
		}
	}

	cout << D[test] << endl;


}