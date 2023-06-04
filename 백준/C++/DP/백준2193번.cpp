#include <iostream>
using namespace std;
long long int d[91][2]; // i자리이고 마지막자리가 j인 이친수의 개수


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	d[0][0] = 0;
	d[1][1] = 1;
	d[1][0] = 0;

	for (int i = 2; i <= num; i++) {
		d[i][0] = d[i - 1][0] + d[i - 1][1]; // 마지막자리가 0인경우
		d[i][1] = d[i - 1][0]; // 마지막 자리가 1인경우
	}
	long long int res = d[num][0] + d[num][1];
	cout << res << endl;
}