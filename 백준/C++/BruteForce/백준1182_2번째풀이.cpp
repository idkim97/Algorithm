#include <iostream>


using namespace std;

int n;
int s;
int arr[100];
int res = 0;


void dfs(int index, int sum) {

	if (sum == s) {
		res++;
	}
	for (int i = index; i < n; i++) {
		int temp = sum + arr[i];
		dfs(i + 1, temp);
	}

}

int main() {
	cin >> n >> s;
	for (int i = 0; i < n; i++) cin >> arr[i];

	dfs(0, 0);
	if (s == 0) res--;
	cout << res << endl;
}