#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	vector <int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];

	if (prev_permutation(a.begin(), a.end())) {
		for (int i = 0; i < n; i++) {
			cout << a[i] << " ";
		}
	}
	else cout << "-1" << endl;
		
	
}