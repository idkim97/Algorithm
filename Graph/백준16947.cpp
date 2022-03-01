#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n;
vector <int> a[3000]; // 인접리스트
int check[3000]; // 0:방문 x ,  1: 방문 ,2: 사이클
int dist[3000];

int cycle(int x, int p) {
	// -2 : 사이클이 있지만 포함되진 않을때
	// -1 : 사이클이 발견되지 않을때
	// 0~n-1 : 사이클도 있고 포함될때

	if (check[x] == 1) { // 이미 방문한 노드라면 해당 노드를 반환
		return x;
	}

	check[x] = 1;

	for (int i : a[x]) {
		if (i == p) continue; // 2개의 노드로 사이클이 만들어지는것 방지
		int res = cycle(i, x);
		if (res == -2) return -2; // 사이클에 포함되지 않는 간선
		if (res >= 0) {
			check[x] = 2;
			if (x == res) return -2; // 사이클의 출발지점과 동일하다
			else return res;
		}
	}


	return -1;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int u, v;
		cin >> u >> v;
		u--; v--;
		a[u].push_back(v);
		a[v].push_back(u);
	}

	cycle(0,-1);
	queue<int> q;
	for (int i = 0; i < n; i++) {
		if (check[i] == 2) {
			dist[i] = 0;
			q.push(i);
		}
		else {
			dist[i] = -1;
		}
	}
	while (!q.empty()) {
		int x = q.front(); q.pop();
		for (int y : a[x]) {
			if (dist[y] == -1) {
				q.push(y);
				dist[y] = dist[x] + 1;
			}
		}
	}
	for (int i = 0; i < n; i++) {
		cout << dist[i] << ' ';
	}
	cout << '\n';
	return 0;


}