#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
char board[30][30];
int res = 0;
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int check[30];

int m, n;

void move(int x, int y, int cnt) {

	res = max(res, cnt);

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
			if (check[board[nx][ny] - 'A'] == 0) {
				check[board[nx][ny] - 'A'] = 1;
				move(nx, ny, cnt+1);
				check[board[nx][ny] - 'A'] = 0;
			}
		}
	}
}

int main() {
	cin >> m >> n;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
		}
	}
	check[board[0][0] - 'A'] = 1;
	move(0, 0, 1);

	cout << res << endl;
}