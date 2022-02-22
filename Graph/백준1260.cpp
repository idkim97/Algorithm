#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

bool check[1001]; // 노드 방문 확인
vector <int> a[1001]; // 인접리스트 


void dfs(int node) {
	check[node] = true;
	cout << node << " ";
	for (int i = 0; i < a[node].size(); i++) {
		int next = a[node][i];
		if (check[next] == false) {
			dfs(next);
		}
	}
}

void bfs(int start) {
	queue<int> q;
	memset(check, false, sizeof(check));
	check[start] = true;
	q.push(start);
	while (!q.empty()) {
		int node = q.front();
		q.pop();
		cout << node << " ";
		for (int i = 0; i < a[node].size(); i++) {
			int next = a[node][i];
			if (check[next] == false) {
				check[next] = true;
				q.push(next);
			}
		}
	}
}


int main() {

	int n, m, v;
	cin >> n >> m >> v;

	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;

		a[u].push_back(v);
		a[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		sort(a[i].begin(), a[i].end());
	}

	dfs(v);
	cout << "\n";
	bfs(v);
	cout << "\n";
	return 0;


}