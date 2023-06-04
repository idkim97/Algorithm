#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n;
vector <int> a[3000]; // ��������Ʈ
int check[3000]; // 0:�湮 x ,  1: �湮 ,2: ����Ŭ
int dist[3000];

int cycle(int x, int p) {
	// -2 : ����Ŭ�� ������ ���Ե��� ������
	// -1 : ����Ŭ�� �߰ߵ��� ������
	// 0~n-1 : ����Ŭ�� �ְ� ���Եɶ�

	if (check[x] == 1) { // �̹� �湮�� ����� �ش� ��带 ��ȯ
		return x;
	}

	check[x] = 1;

	for (int i : a[x]) {
		if (i == p) continue; // 2���� ���� ����Ŭ�� ��������°� ����
		int res = cycle(i, x);
		if (res == -2) return -2; // ����Ŭ�� ���Ե��� �ʴ� ����
		if (res >= 0) {
			check[x] = 2;
			if (x == res) return -2; // ����Ŭ�� ��������� �����ϴ�
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