#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool a[2000][2000]; // 인접행렬
vector <int> g[2000]; // 인접리스트
vector <pair<int, int>> edges;  // 간선리스트


int main() {

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int from, to;
		cin >> from >> to;

		edges.push_back({ from, to }); // 간선리스트 만들기 ... etc) edges[0] = 0 1  , edges[1] = 1 2
		edges.push_back({ to, from }); // 간선리스트 만들기

		a[from][to] = a[to][from] = true; // 인접행렬 만들기 ... etc) 연결되어있으면 1 아니면 0

		g[from].push_back(to); // 인접리스트 만들기 ... etc) g[0] 1  , g[1] 0 2 
		g[to].push_back(from); // 인접리스트 만들기
	}

	m *= 2;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < m; j++) {

			// A->B
			int A = edges[i].first;
			int B = edges[i].second;

			// C->D
			int C = edges[j].first;
			int D = edges[j].second;

			if (A == B || B == C || C == D || A == C || A == D || B == D) continue;

			// B->C
			if (!a[B][C]) continue;

			for (int E : g[D]) {
				if (A == E || B == E || C == E || D == E) continue;
				cout << 1 << "\n";
				return 0;
			}
		}
	}

	cout << 0 << endl;
	return 0;

}