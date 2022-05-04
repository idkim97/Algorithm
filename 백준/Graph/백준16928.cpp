#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m; // 사다리 n , 뱀 m
int res;
int next_move[200]; // x에서 y로 움직이는 거 입력
int d[200]; // 방문안한경우 : -1 , 나머지는 주사위 굴린수


int main() {
	cin >> n >> m;

	for (int i = 1; i <= 100; i++) {
		next_move[i] = i;
		d[i] = -1;
	}

	for (int i = 0; i < n + m; i++) {
		int x, y;
		cin >> x >> y;
		next_move[x] = y;
	}

	queue <int> q;
	q.push(1);
	d[1] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		for (int i = 1; i <= 6; i++) {
			int next = cur + i;
			if (next > 100) continue;
			next = next_move[next];
			if (d[next] == -1) {
				d[next] = d[cur] + 1;
				q.push(next);
			}
		}
	}

	cout << d[100] << endl;




}