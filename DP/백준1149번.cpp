#include <iostream>
#include <algorithm>
using namespace std;

int color[1001][3];
int d[1001][3]; // i번째집을 j로 칠했을 때, 1~i까지 칠하는 비용의 최솟값
				// 0=R, 1=G, 2=B

int main() {

	int test;
	cin >> test;

	for (int i = 1; i <= test; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> color[i][j];
		}
	}

	for (int i = 1; i <= test; i++) {
		d[i][0] = min(d[i - 1][1], d[i - 1][2]) + color[i][0];
		d[i][1] = min(d[i - 1][0], d[i - 1][2]) + color[i][1];
		d[i][2] = min(d[i - 1][0], d[i - 1][1]) + color[i][2];
	}

	int res = min({ d[test][0], d[test][1], d[test][2] });

	cout << res << endl;


}