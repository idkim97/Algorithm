#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
int res[100]; // 결과
int v[100]; // 입력받은 사용할 숫자

void go(int index, int depth) {
	if (depth == 6) {
		for (int i = 0; i < 6; i++) {
			cout << res[i] << " ";
		}
		cout << "\n";
	}
	else {
		for (int i = index; i < n; i++) {
			res[depth] = v[i];
			go(i + 1, depth + 1);
		}
	}


}

int main() {

	while (1) {
		cin >> n;
		if (n == 0) break;
		for (int i = 0; i < n; i++) {
			cin >> v[i];
		}

		go(0, 0);
		cout << "\n";


	}
}