#include <iostream>
#include <queue>

using namespace std;
int n;
int r1, r2, c1, c2;
int dx[] = { -2,-2,0,0,2,2 };
int dy[] = { -1,1,-2,2,-1,1 };
int d[200][200]; // 방문안했을때 -1, 나머지는 최소 이동횟수

int main() {
	cin >> n;
	cin >> r1 >> c1 >> r2 >> c2;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			d[i][j] = -1;
		}
	}

	d[r1][c1] = 0;
	queue <pair<int, int>> q;

	q.push(make_pair(r1, c1));
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 6; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (d[nx][ny] == -1) {
					d[nx][ny] = d[x][y] + 1;
					q.push(make_pair(nx, ny));
				}
			}
		}
	}

	if (d[r2][c2] == -1) cout << -1 << endl;
	else
		cout << d[r2][c2] << endl;


}