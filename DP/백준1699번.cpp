#include <iostream>

using namespace std;

int d[100001]; // 제곱수항의 최소개수


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	d[0] = 0;

	for (int i = 1; i <= num; i++) {
		d[i] = i;
		for (int j = 1; j * j <= i; j++) {
			if (d[i] > d[i - j * j] + 1)
				d[i] = d[i - j * j] + 1;
		}
	}

	cout << d[num] << endl;

}