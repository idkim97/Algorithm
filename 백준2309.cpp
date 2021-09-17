#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int cnt = 0,sum = 0,finish = 0;
vector <int> res;
void combination(int dwarf[]) {
	if (cnt == 7) {
		if (sum == 100) {
			for (int i = 0; i < 7; i++) cout << res[i] << "\n";
			finish = 1;
		}
		return;
	}
	else {
		for (int i = 0; i < 9; i++) {
			if (finish == 1) return;
			if (res.empty() || res.back() < dwarf[i]) {
				res.push_back(dwarf[i]);
				cnt++;
				sum += dwarf[i];
				combination(dwarf);
				res.pop_back();
				sum -= dwarf[i];
				cnt--;
			}
		}
	}
}

int main() {
	int dwarf[9] = { 0 };
	for (int i = 0; i < 9; i++) cin >> dwarf[i];
	sort(dwarf, dwarf + 8);
	combination(dwarf);

	return 0;
}
