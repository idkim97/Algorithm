#include <iostream>
#include <stack>
#include <string>
using namespace std;

int D[1000000]; // D[N]�� 1�� ����µ� �ʿ��� ���� Ƚ��


int func(int num) {

	if (num == 1) return 0; // D[1]�ΰ�� 0�������ϹǷ� 
	if (D[num] > 0) return D[num]; // memoization

	D[num] = func(num - 1) + 1;

	if (num % 3 == 0) {
		int temp = func(num / 3) + 1;
		if (D[num] > temp) D[num] = temp;
	}

	if (num % 2 == 0) {
		int temp = func(num / 2) + 1;
		if (D[num] > temp)  D[num] = temp;
	}
	
	return D[num];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int num;
	cin >> num;

	int res = func(num);
	cout << res;
	


}