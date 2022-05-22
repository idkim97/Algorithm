#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int n, k; // 보석개수, 가방개수
vector <pair<int, int>> jew; // 보석 무게 , 가격
vector <int> pack; // 가방 무게
long long res = 0;

int main() {
	cin >> n >> k;
	priority_queue<int> pq; // 보석을 담을 우선순위 큐

	for (int i = 0; i < n; i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;
		jew.push_back({ temp1,temp2 });
	}

	// 보석 무게 오름차순 정렬
	sort(jew.begin(), jew.end());

	for (int i = 0; i < k; i++) {
		int back;
		cin >> back;
		pack.push_back(back);
	}

	// 가방 무게 오름차순 정렬
	sort(pack.begin(), pack.end());

	int index = 0;
	for (int i = 0; i < k; i++) {
		while (index < n && pack[i] >= jew[index].first ) {
			pq.push(jew[index].second);
			index++;
		}
		if (!pq.empty()) {
			res += (long long)pq.top();
			pq.pop();
		}
	}

	cout << res << endl;
}