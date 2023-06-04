#include <iostream>
#include <vector>
#include <string>
#define TEMP 2147483647
using namespace std;
int n, m;
string board[30];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int c1x, c1y, c2x, c2y;
int cnt = 0;
int result = TEMP;

void dfs(int cnt, int c1x, int c1y, int c2x, int c2y) {

	if (cnt == 10) return;

	for (int i = 0; i < 4; i++) {
		int nx = c1x + dx[i];
		int ny = c1y + dy[i];
		int nxx = c2x + dx[i];
		int nyy = c2y + dy[i];

		// 범위안에 들어온 경우
		if (nx >= 0 && nx < n && ny >= 0 && ny < m && nxx >= 0 && nxx < n && nyy >= 0 && nyy < m) {
			// 동전1과 동전2가 둘다 벽에 막혀 못움직이는 경우
			if (board[nx][ny] == '#' && board[nxx][nyy] == '#') {
				continue;
			}
			// 동전1이 벽에 막혀 못움직이는 경우
			if (board[nx][ny] == '#') {
				nx = c1x, ny = c1y;
			}
			// 동전2가 벽에 막혀 못움직이는 경우
			if (board[nxx][nyy] == '#') {
				nxx = c2x, nyy = c2y;
			}
			dfs(cnt + 1, nx, ny, nxx, nyy);
		}
		// 둘다 떨어진경우
		else if ((nx < 0 || nx >= n || ny < 0 || ny >= m) && (nxx < 0 || nxx >= n || nyy < 0 || nyy >= m)) {
			continue;
		}
		else {
			if (result > cnt + 1) {
				result = cnt + 1;
			}
		}
	}
	return;

}

int main() {
	bool check = true;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> board[i];
		for (int j = 0; j < m; j++) {
			if (board[i][j] == 'o' && check == true) {
				c1x = i, c1y = j;
				check = false;
			}
			if (board[i][j] == 'o' && check == false) {
				c2x = i, c2y = j;
			}
		}
	}

	dfs(cnt, c1x, c1y, c2x, c2y);

	if (result == TEMP) cout << -1;
	else cout << result << endl;
}