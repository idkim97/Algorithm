#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long n;


int main() {
	int max = 1;
	long long res = 0;

	cin >> n;
	vector <long long> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}

	sort(v.begin(), v.end());

	int cnt = 1;

	res = v[0];

	for (int i = 1; i < n; i++) {
		if (v[i] == v[i - 1]) {
			cnt++;
		}
		else {
			cnt = 1;
		}

		if (max < cnt) {
			max = cnt;
			res = v[i];
		}
	}

	cout << res << endl;
}