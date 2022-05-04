#include <iostream>
using namespace std;

long long int d[101][10]; // 길이가 i이면서 마지막자리가 j인 계단수의 개수
const long long int mod = 1000000000LL;

int main() {
	int num;
	cin >> num;

	for (int i = 1; i <= 9; i++) d[1][i] = 1; // 길이가 1인 계단수

	for (int i = 2; i <= num; i++) {
		for (int j = 0; j <= 9; j++) {
			d[i][j] = 0; // 배열 초기화
			if (j == 0) d[i][j] = d[i - 1][j + 1]; // 마지막자리가 0일때 
			else if (j == 9) d[i][j] = d[i - 1][j - 1]; // 마지막자리가 9일때
			else d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]); // 나머지

			d[i][j] %= mod;
		}
	}

	long long int res = 0;
	for (int i = 0; i <= 9; i++) {
		res += d[num][i];
	}
	res %= mod;

	cout << res << endl;
}