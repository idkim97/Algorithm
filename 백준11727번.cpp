#include <iostream>
using namespace std;

int D[100007];

int square(int num) {
	D[0] = 1;
	D[1] = 1;

	for (int i = 2; i <= num; i++) {
		D[i] = D[i - 1] + 2*D[i - 2];
		D[i] %= 10007;
	}
	int res = D[num];

	return res;
}
int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	cin >> N;

	int res = square(N);

	cout << res << endl;
}