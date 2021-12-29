#include <iostream>
using namespace std;

// BottomUp ¹æ½Ä
int D[1000000];

int main() {
	int num;
	cin >> num;

	D[1] = 0;

	for (int i = 2; i <= num; i++) {
		D[i] = D[i - 1] + 1;
		if (i % 3 == 0 && D[i] > D[i / 3] + 1)
			D[i] = D[i / 3] + 1;
		if (i % 2 == 0 && D[i] > D[i / 2] + 1)
			D[i] = D[i / 2] + 1;
	}

	cout << D[num] << endl;


}

