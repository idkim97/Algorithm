#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>


using namespace std;

int island[51][51]; // 1이면 땅, 0이면 바다
int check[51][51]; // 1이면 방문, 0이면 미방문
int w, h;
int dx[] = { -1,0,1,1,1,0,-1,-1 };
int dy[] = { 1,1,1,0,-1,-1,-1,0 };
int cnt = 0;

void dfs(int x, int y) {
	check[x][y] = 1;
	for (int i = 0; i < 8; i++) {
		int tempx = x + dx[i];
		int tempy = y + dy[i];
		if (0 <= tempx && tempx < w && 0 <= tempy && tempy < h) {
			if (check[tempx][tempy] == 0 && island[tempx][tempy] == 1) {
				dfs(tempx, tempy);
			}
		}
	}

}

int main() {
	while (1) {
		scanf("%d %d", &h, &w);
		if (w == 0 && h == 0) break;

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				scanf("%1d", &island[i][j]);
			}
		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (check[i][j] == 0 && island[i][j] == 1) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				check[i][j] = 0;
			}
		}

		cout << cnt << "\n";
		cnt = 0;
	}
}