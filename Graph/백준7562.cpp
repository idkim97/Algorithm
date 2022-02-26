#include <iostream>
#include <queue>


using namespace std;


pair <int, int> start;
pair <int, int> final;
int dx[] = { -2,-1,1,2,2,1,-1,-2 };
int dy[] = { 1,2,2,1,-1,-2,-2,-1 };
int arr[301][301];

int main() {
	int test;
	cin >> test;

	while (test--) {
		int l;
		int temp1, temp2;
		int temp3, temp4;

		cin >> l;
		cin >> temp1 >> temp2;

		cin >> temp3 >> temp4;
		

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				arr[i][j] = -1;
			}
		}



		queue <pair<int, int>> q;
		q.push(make_pair(temp1,temp2));
		arr[temp1][temp2] = 0;

		while (!q.empty()) {
			int x = q.front().first;
			int y = q.front().second;
			q.pop();
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < l && 0 <= ny && ny < l) {
					if (arr[nx][ny] == -1) {
						q.push(make_pair(nx, ny));
						arr[nx][ny] = arr[x][y] + 1;
					}
				}

			}
		}

		cout << arr[temp3][temp4] << "\n";


	}
}