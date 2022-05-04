#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	while (1) {
		int k;
		cin >> k;
		if (k == 0) break;
		vector <int> a(k);
		for (int i = 0; i < k; i++) cin >> a[i];

		vector<int> d;
		for (int i = 0; i < k - 6; i++) {
			d.push_back(0);
		}
		for (int i = 0; i < 6; i++) {
			d.push_back(1);
		}

		vector <vector<int>> ans;

		do {
			vector <int> temp;
			for (int i = 0; i < k; i++) {
				if (d[i] == 1) {
					temp.push_back(a[i]);
				}
			}
			ans.push_back(temp);
		} while (next_permutation(d.begin(), d.end()));

		sort(ans.begin(), ans.end());

		for (auto& v : ans) {
			for (int i = 0; i < v.size(); i++) {
				cout << v[i] << " ";
			}
			cout << "\n";
		}
		cout << "\n";
	}
	return 0;

}