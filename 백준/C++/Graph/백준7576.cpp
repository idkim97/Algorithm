#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int m, n;
int arr[1001][1001];
int dist[1001][1001];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };

int main() {
	queue<pair<int, int>> q;

	cin >> m;
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			dist[i][j] = -1;
			if (arr[i][j] == 1) {
				q.push(make_pair(i, j));
				dist[i][j] = 0;
			}
		}
	}

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (dist[nx][ny]==-1 && arr[nx][ny] == 0) {
					q.push(make_pair(nx, ny));
					dist[nx][ny] = dist[x][y] + 1;
				}
			}
		}
	}
	int ans = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			ans = max(ans, dist[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 0 && dist[i][j] == -1) {
				ans = -1;
			}
		}
	}


	cout << ans << endl;
	return 0;



}