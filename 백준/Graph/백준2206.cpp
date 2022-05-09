#include <iostream>
#include <queue>

using namespace std;

int n, m;
int arr[1001][1001];
int visit[1001][1001][2]; // 최단거리값
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

int bfs() {
	queue <pair<pair<int, int>, int>> q; // x좌표, y좌표, 벽뚫 유무
	q.push({ { 1,1 }, 0 });
	visit[1][1][0] = 1;
	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int wall = q.front().second;
		q.pop();

		if (x == n && y == m) return visit[x][y][wall];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
				// 벽이 없고 아직 방문하지 않은 경우
				if (arr[nx][ny] == 0 && visit[nx][ny][wall] == 0) {
					visit[nx][ny][wall] = visit[x][y][wall] + 1;
					q.push({ { nx,ny }, wall });
				}

				// 벽이 있고 아직 벽을 뚫지 않은 경우
				if (arr[nx][ny] == 1 && wall == 0) {
					visit[nx][ny][wall + 1] = visit[x][y][wall] + 1;
					q.push({ {nx,ny}, wall + 1 });
				}
			}
		}
	}
	return -1;
}
int main() {

	scanf("%d %d", &n, &m);

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%1d", &arr[i][j]);
		}
	}

	cout << bfs() << endl;

	

}