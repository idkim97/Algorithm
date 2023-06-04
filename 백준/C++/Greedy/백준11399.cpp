#include <iostream>
#include <algorithm>
using namespace std;

int n;
int arr[1001];

int main() {
	int res = 0;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> arr[i];
	sort(arr, arr + n);
	for (int i = 0; i <n; i++) {
		for (int j = 0; j <= i; j++) {
			res += arr[j];
		}
	}

	cout << res << endl;
}