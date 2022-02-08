#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int l, c;
	cin >> l;
	cin >> c;

	vector <char> d(c);

	for (int i = 0; i < c; i++) cin >> d[i];

	vector <int> a;

	for (int i = 0; i < c - l; i++) a.push_back(0);
	for (int i = 0; i < l; i++) a.push_back(1);

	vector <vector<char>> ans;
	int countmo = 0;
	int countja = 0;

	do {
		vector <char> temp;
		for (int i = 0; i < c; i++) {
			if (a[i] == 1) {
				temp.push_back(d[i]);
				if (d[i] == 'a' || d[i] == 'e' || d[i] == 'i' || d[i] == 'o' || d[i] == 'u')
					countmo++;
				else countja++;
			}
		}
		if (countmo >= 1 && countja >= 2) {
			sort(temp.begin(), temp.end());
			ans.push_back(temp);
		}
		

		countmo = 0;
		countja = 0;

	} while (next_permutation(a.begin(), a.end()));

	sort(ans.begin(), ans.end());

	for (auto& v : ans) {
		for (int i = 0; i < v.size(); i++) {
			cout << v[i];
		}
		cout << "\n";
	}

	return 0;

}