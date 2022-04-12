#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int t;
int check[10000];
int a, b;

int D(int n) {
	int res = (2 * n) % 10000;
	return res;
}

int S(int n) {
	int res = n - 1;
	if (n== 0) return 9999;
	else return res;
}

int L(int n) {
	int res = (n % 1000) * 10 + n / 1000;
	return res;
}

int R(int n) {
	int res = n / 10 + n % 10 * 1000;
	return res;
}

void bfs() {
	queue <pair<int, string>> q;
	q.push(make_pair(a, ""));
	check[a] = 1;

	while (!q.empty()) {
		int cur = q.front().first;
		string cur_op = q.front().second;
		q.pop();

		if (cur == b) {
			cout << cur_op << "\n";
			return;
		}


		if (check[D(cur)] == -1) {
			check[D(cur)] = 1;
			q.push(make_pair(D(cur), cur_op + "D"));
		}

		if (check[S(cur)] == -1) {
			check[S(cur)] = 1;
			q.push(make_pair(S(cur), cur_op + "S"));
		}

		if (check[L(cur)] == -1) {
			check[L(cur)] = 1;
			q.push(make_pair(L(cur), cur_op + "L"));
		}

		if (check[R(cur)] == -1) {
			check[R(cur)] = 1;
			q.push(make_pair(R(cur), cur_op + "R"));
		}

	}
}
int main() {
	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> a >> b;
		memset(check, -1, sizeof(check));
		bfs();
	}
}