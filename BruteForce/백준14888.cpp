#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#define MAX -1000000001
#define MIN 1000000001

using namespace std;

int n;
int num[200]; // 사용할 숫자
vector <int> oper; // 연산자의 개수 (+,-,x,÷)
int maxres = MAX;
int minres = MIN;
int res = 0;


int main() {
	cin >> n;
	for (int i = 0; i < n; i++) cin >> num[i];
	for (int i = 0; i < 4; i++) {
		int temp;
		cin >> temp;
		for (int j = 0; j < temp; j++) {
			oper.push_back(i);
		}
	}


	do {
		res = num[0];
		for (int i = 0; i < n - 1; i++) {
			if (oper[i] == 0) {
				res = res + num[i + 1];
			}
			else if (oper[i] == 1) {
				res = res - num[i + 1];
			}
			else if (oper[i] == 2) {
				res = res * num[i + 1];
			}
			else if (oper[i] == 3) {
				res = res / num[i + 1];
			}
		}
		if (res > maxres) {
			maxres = res;
		//	cout << "max : " << maxres << endl;
		}
		if (res < minres) {
			minres = res;
		//	cout << "min : " <<  minres << endl;
		}
	} while (next_permutation(oper.begin(), oper.end()));

	cout << maxres << "\n";
	cout << minres << "\n";


}