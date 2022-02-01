#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector <int> a(n);
	int temp = 1;
	for (int i = 0; i < n; i++) {
		a[i] = i+1;
		temp *= i+1;
	}

	for (int i = 0; i < temp; i++) {
		if (i == 0) {
			for (int j = 0; j < n; j++) {
				cout << a[j] << " ";
			}
			cout << "\n";
		}
		if (next_permutation(a.begin(), a.end())) {
			for (int j = 0; j < n; j++) {
				cout << a[j] << " ";
			}
		}
		else return 0;
		cout << "\n";
	}
}