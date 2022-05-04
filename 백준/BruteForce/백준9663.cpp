#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

int n;
int chess[20]; 
int res;

bool check(int x) {
	for (int i = 0; i < x; i++) {
		if (chess[x] == chess[i] || abs(chess[x] - chess[i]) == x-i) {
			return false;
		}
	}
	return true;
}

void queen(int x) {

	if (x == n) {
		res++;
	}
	for (int i = 0; i < n; i++) {
		chess[x] = i; // x,i에 퀸이 있다는 뜻
		if (check(x)) {
			queen(x + 1);
		}
	}
}

int main() {
	cin >> n;
	queen(0);
	cout << res << endl;
}