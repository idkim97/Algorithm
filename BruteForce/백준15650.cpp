#include <iostream>
#include <algorithm>
using namespace std;

bool c[10];
int a[10];
bool check = false;

void go(int index, int n, int m) {
	// �������� Ȯ��
	for (int i = 0; i < m-1; i++) {
		if (a[i] < a[i + 1]) check = true;
		else {
			check = false;
			break;
		}
	}

	// m=1�ΰ�� ����ó��
	if (m == 1) check = true;

	// ���������̸� ������ �ϼ��� ��� ���
	if (index == m && check == true) {
		for (int i = 0; i < m; i++) {
			cout << a[i];
			if (i != m - 1) cout << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (c[i] == true) continue;
		a[index] = i;
		c[i] = true;
		go(index + 1, n, m);
		c[i] = false;
	}
}

int main() {
	int n, m;
	cin >> n >> m;

	go(0, n, m);
	return 0;
}