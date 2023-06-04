#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
int start;
int finish;
int res = 1;
vector <pair<int, int>> sc;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> start >> finish;
		sc.push_back({ finish,start });
	}

	sort(sc.begin(), sc.end());

	// ù��° �������� ����ð� <= �ι�° �������� ���۽ð�

	int curtime = sc.front().first;
	for (int i = 1; i < n; i++) {
		if (curtime <= sc[i].second) {
			curtime = sc[i].first;
			res++;
		}
	}

	cout << res << endl;
	

}