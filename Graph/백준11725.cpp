#include <iostream>
#include <queue>
#define MAX 100001

using namespace std;
vector <int> a[MAX];
int check[MAX];
int depth[MAX];
int parent[MAX];

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n-1; i++) {
		int u, v;
		cin >> u >> v;

		a[u].push_back(v);
		a[v].push_back(u);
	}

	queue <int> q;
	q.push(1);
	check[1] = 1;
	parent[1] = 0;
	depth[1] = 0;

	while (!q.empty()) {
		int node = q.front();
		q.pop();

		for (int next : a[node]) {
			if (check[next] == 0) {
				depth[next] = depth[node] + 1;
				check[next] = 1;
				parent[next] = node;
				q.push(next);
			}
		}
	}

	for (int i = 2; i <=n; i++) {
		cout << parent[i] << "\n";
	}
}