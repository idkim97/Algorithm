#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int n, k; // ��������, ���氳��
vector <pair<int, int>> jew; // ���� ���� , ����
vector <int> pack; // ���� ����
long long res = 0;

int main() {
	cin >> n >> k;
	priority_queue<int> pq; // ������ ���� �켱���� ť

	for (int i = 0; i < n; i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;
		jew.push_back({ temp1,temp2 });
	}

	// ���� ���� �������� ����
	sort(jew.begin(), jew.end());

	for (int i = 0; i < k; i++) {
		int back;
		cin >> back;
		pack.push_back(back);
	}

	// ���� ���� �������� ����
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