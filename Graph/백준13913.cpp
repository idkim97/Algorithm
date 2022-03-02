#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int check[200001];
int dist[200001];
int from[200001];  // a->b로 이동할때 a저장

void print(int n, int k) {
	if (n != k) {
		print(n, from[k]);
	}
	cout << k << " ";
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, k;

	cin >> n >> k;

	queue <int> q;
	q.push(n);
	dist[n] = 0;
	check[n] = 1;
	//memset(dist, 0, sizeof(dist));
	//memset(check, 0, sizeof(check));

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		//check[x] = 1;

		if (x - 1 >= 0) {
			if (check[x - 1] == 0) {
				q.push(x - 1);
				check[x - 1] = 1;
				dist[x - 1] = dist[x] + 1;
				from[x - 1] = x;
			}
		}

		if (x + 1 < 200000) {
			if (check[x + 1] == 0) {
				q.push(x + 1);
				check[x + 1] = 1;
				dist[x + 1] = dist[x] + 1;
				from[x + 1] = x;
			}
		}
		if (2 * x < 200000) {
			if (check[2 * x] == 0) {
				q.push(2 * x);
				check[2 * x] = 1;
				dist[2 * x] = dist[x] + 1;
				from[2 * x] = x;
			}
		}
	}
	
	cout << dist[k] << "\n";
	print(n, k);
	
	return  0;
}
