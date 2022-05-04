#include <iostream>
#include <queue>
#include <deque>
#include <cstring>

using namespace std;

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
int arr[101][101];
int check[101][101];
int dist[101][101];

int n, m;

int main() {
	scanf("%d %d", &m, &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &arr[i][j]);
			dist[i][j] = -1;
		}
	}

	deque <pair<int, int>> q;
	q.push_back({ 0,0 });
	dist[0][0] = 0;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop_front();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (dist[nx][ny] == -1 && arr[nx][ny] == 0) {
					q.push_front({ nx,ny });
					dist[nx][ny] = dist[x][y];
				}
				if (dist[nx][ny] == -1 && arr[nx][ny] == 1) {
					q.push_back({ nx,ny });
					dist[nx][ny] = dist[x][y] + 1;
				}
			}
		}
	}

	printf("%d\n", dist[n - 1][m - 1]);
	return 0;
	

}