#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

int n, m;
char d[51][51];
int check[51][51];
int dist[51][51];
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };

bool dfs(int x, int y, int cnt, char color) {
	if (check[x][y]) {
		if (cnt - dist[x][y] >= 4) {
			return true;
		}
		else return false;
	}

	check[x][y] = true;
	dist[x][y] = cnt;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (0 <= nx && nx < n && 0 <= ny && ny < m) {
			if (d[nx][ny] == color) {
				if(dfs(nx, ny, cnt + 1, color)) {
					return true;
				}
			}
		}
	}

	return false;
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> d[i];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (check[i][j]) continue;
			memset(dist, 0, sizeof(dist));
			bool ok = dfs(i, j, 1, d[i][j]);
			if (ok) {
				cout << "Yes" << '\n';
				return 0;
			}
		}
	}
	cout << "No" << '\n';
	return 0;
}