#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>

#define RED 1
#define BLUE 2


using namespace std;

int check[20001];
vector<int> a[20001]; // ���Ḯ��Ʈ
int k,v, e;

void dfs(int node) {
	// ���۳��� RED��� ����
	if (!check[node]) {
		check[node] = RED;
	}

	for (int i = 0; i < a[node].size(); i++) {
		int next = a[node][i];
		// ������带 �湮���� �������
		if (!check[next]) {
			// ���۳�尡 RED�̸� ������带 BLUE�� ����
			if (check[node] == RED) check[next] = BLUE;
			// ���۳�尡 BLUE�̸� ������带 RED�� ����
			else if (check[node] == BLUE) check[next] = RED;
			dfs(next);
		}
	}
}

bool isBipartGraph() {
	for (int i = 1; i <= v; i++) {
		for (int j = 0; j < a[i].size(); j++) {
			int next = a[i][j];
			if (check[i] == check[next]) return 0;
		}
	}
	return 1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> k;

	while (k--) {

		cin >> v >> e;

		for (int i = 0; i < e; i++) {
			int u, p;
			cin >> u >> p;
			a[u].push_back(p);
			a[p].push_back(u);
		}

		for (int i = 1; i <= v; i++) {
			if (!check[i]) dfs(i);
		}

		if (isBipartGraph()) cout << "YES\n";
		else cout << "NO\n";

		for (int i = 0; i <= v; i++) {
			a[i].clear();
			check[i] = 0;
		}

		//memset(check, false, sizeof(check));
	}
	return 0;
}
