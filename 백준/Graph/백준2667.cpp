#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>



using namespace std;

int n;
int house[30][30]; // �� �Է¹ޱ�
int check[30][30]; // �湮������ 1 �������� 0

int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
int ans[25 * 25];

void dfs(int x, int y, int cnt) {
	check[x][y] = cnt;
	for (int i = 0; i < 4; i++) {
		int tempx = x + dx[i];
		int tempy = y + dy[i];
		if (0 <= tempx && tempx < n && 0 <= tempy && tempy < n) {
			if (house[tempx][tempy] == 1 && check[tempx][tempy] == 0)
				dfs(tempx, tempy, cnt);
		}
	}
}


int main() {

	// c�� c++�� �Է��� ȥ���ؼ� ���� �����߻� ����
	//ios_base::sync_with_stdio(false);
	//cin.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &house[i][j]); // ���ڰ� ���� ���� ����Ǿ� �������� 1d�� �޾ƾ� �Ѱ��� �Է¹��� �� ����
		}
	}

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (house[i][j] == 1 && check[i][j] == 0) {
				dfs(i, j, ++cnt);
			}
		}
	}

	cout << cnt << "\n";

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			ans[check[i][j]] += 1;
		}
	}
	sort(ans + 1, ans + cnt + 1);
	for (int i = 1; i <= cnt; i++) {
		printf("%d\n", ans[i]);
	}
	return 0;


}
