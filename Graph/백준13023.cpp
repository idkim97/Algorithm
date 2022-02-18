#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool a[2000][2000]; // �������
vector <int> g[2000]; // ��������Ʈ
vector <pair<int, int>> edges;  // ��������Ʈ


int main() {

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int from, to;
		cin >> from >> to;

		edges.push_back({ from, to }); // ��������Ʈ ����� ... etc) edges[0] = 0 1  , edges[1] = 1 2
		edges.push_back({ to, from }); // ��������Ʈ �����

		a[from][to] = a[to][from] = true; // ������� ����� ... etc) ����Ǿ������� 1 �ƴϸ� 0

		g[from].push_back(to); // ��������Ʈ ����� ... etc) g[0] 1  , g[1] 0 2 
		g[to].push_back(from); // ��������Ʈ �����
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