#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>


using namespace std;

bool check[1001];
vector<int> a[500001]; // ���Ḯ��Ʈ
int res = 0;

void dfs(int node) {
	check[node] = true;
	for (int i = 0; i < a[node].size(); i++) {
		int next = a[node][i];
		if (check[next] == false) {
			dfs(next);
		}
	}
}

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		a[u].push_back(v); // ���Ḯ��Ʈ ����
		a[v].push_back(u); // ���Ḯ��Ʈ ����
	}

	for (int i = 1; i <= n; i++) {
		if (check[i] == false) {
			dfs(i);
			res += 1;
		}
	}

	cout << res;

	return 0;
}