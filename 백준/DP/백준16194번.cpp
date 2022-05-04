#include <iostream>
#include <algorithm>
using namespace std;

int D[1001]; // N���� �����ϴµ� �ʿ��� �ּ� ���


int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int test;
	cin >> test;
	int res = 0;

	int buy[10001]; // i���� �����ϴµ� �ʿ��� ��
	D[0] = 0;
	buy[0] = 10000;

	for (int i = 1; i <= test; i++) {
		cin >> buy[i];
		D[i] = -1;
	}

	for (int i = 1; i <= test; i++) {
		for (int j = 1; j <= i; j++) {
			if (D[i] == -1 || D[i] > D[i - j] + buy[j])
				D[i] = D[i - j] + buy[j];
		}
	}

	cout << D[test] << endl;
}