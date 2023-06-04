#include <iostream>


using namespace std;
int tet[501][501];

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	int m;

	cin >> n;
	cin >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> tet[i][j];
		}
	}
	int max = 0;
	int temp = 0;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (j <= m - 3) { // ㅡㅡㅡㅡ
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i][j + 3];
				if (max < temp) max = temp;
			}
			if (i <= n - 3) { // 일자
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 2][j] + tet[i + 3][j];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 1) { // ㅁ
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j] + tet[i + 1][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // └
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 2][j] + tet[i + 2][j + 1];
				if (max < temp) max = temp;
			}

			if (i <= n - 1 && j <= m - 2) { // ┌
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i + 1][j];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ┐
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j + 1] + tet[i + 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i >= 2 && j <= m - 2) { // ┘
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i - 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 3 && j <= m - 1) { // ┘
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i - 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 2) { // ┐
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i + 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ┌
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 2][j] + tet[i][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 2) { // ㄴ
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 1][j + 1] + tet[i + 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // └┐
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 1][j + 1] + tet[i + 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i >= 2 && j <= m - 1) { // 
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i - 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 3 && j <= m - 1) { // ┌┘
				temp = tet[i][j] + tet[i - 1][j] + tet[i - 1][j + 1] + tet[i - 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 1) { // ㄱㄴ
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j + 1] + tet[i + 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 2 && j <= m - 1) { // ㅗ
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i][j + 2];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ㅏ
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 1][j + 1] + tet[i + 2][j];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 2) { // ㅜ
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j + 1] + tet[i][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 2 && i <= n - 1 && j <= m - 1) { // ㅓ
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i + 1][j + 1];
				if (max < temp) max = temp;
			}
		}
	}

	cout << max << endl;

}