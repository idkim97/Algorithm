#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

int arr[101][101];
int check[100][100];
int dist[100][100];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int n, m;



int main() {

	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &arr[i][j]);
		}
	}
	queue<pair<int, int>> q;
	q.push({ 0, 0 }); // == q.push(make_pair(0,0));
	check[0][0] = 0;
	dist[0][0] = 1;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
					q.push(make_pair(nx, ny));
					dist[nx][ny] = dist[x][y] + 1;
					check[nx][ny] = 1;
				}
			}
		}
	}

	printf("%d\n", dist[n - 1][m - 1]);


}