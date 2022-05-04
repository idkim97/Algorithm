#include <iostream>
#include <queue>
#include <deque>
#include <cstring>
#define MAX 200000

using namespace std;


int check[MAX];
int dist[MAX];


int main() {

	int n, k;
	cin >> n >> k;

	deque<int> q;
	check[n] = 1;
	dist[n] = 0;

	q.push_back(n);
	while (!q.empty()) {
		int x = q.front();
		q.pop_front();

		if (x * 2 < MAX) {
			if (check[x * 2] == 0) {
				q.push_front(x * 2);
				check[x * 2] = 1;
				dist[x * 2] = dist[x];
			}
		}

		if (x + 1 < MAX) {
			if (check[x + 1] == 0) {
				q.push_back(x + 1);
				check[x + 1] = 1;
				dist[x + 1] = dist[x] + 1;
			}
		}
		if (x - 1 >= 0) {
			if (check[x - 1] == 0) {
				q.push_back(x - 1);
				check[x - 1] = 1;
				dist[x - 1] = dist[x] + 1;
			}
		}
		
	}

	cout << dist[k] << endl;
	return 0;
}