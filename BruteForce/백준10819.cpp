#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector <int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];

	sort(a.begin(), a.end());
	int temp = 0;
	int max = 0;

	while (next_permutation(a.begin(), a.end())) {
		for (int i = 0; i < n-1; i++) {
			temp += abs(a[i] - a[i + 1]);
		}
		if (temp > max) {
			max = temp;
			temp = 0;
		}
		else temp = 0;
	}

	cout << max << endl;
}