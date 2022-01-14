#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int key[9];
	int sum = 0;

	for (int i = 0; i < 9; i++) {
		cin >> key[i];
		sum += key[i];
	}

	sort(key, key + 9);
	
	for (int i = 0; i < 9; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (sum - key[i] - key[j] == 100) {
				for (int k = 0; k < 9; k++) {
					if (i == k || j == k) continue;
					cout << key[k] << endl;
				}
				return 0;
			}
		}
	}

	return 0;
}