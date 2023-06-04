#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

using namespace std;
int n, m;
int start[51][51];
int finish[51][51];
int res = 0;


int main() {
	// �Ȱ��� �κ��� �ι� �������� �״�ξ�!!
	// �ּҰ��̴ϱ� ������ ���� ����� �ѹ��� ������ߵ�
	// �������������� ��� ������
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &start[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &finish[i][j]);
		}
	}

	for (int i = 0; i < n - 2; i++) {
		for (int j = 0; j < m - 2; j++) {
			if (start[i][j] == finish[i][j]) continue;
			else if(start[i][j] != finish[i][j]) {
				for (int x = i; x < i + 3; x++) {
					for (int y = j; y < j + 3; y++) {
						if (start[x][y] == 0) start[x][y] = 1;
						else start[x][y] = 0;
					}
				}
				res++;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (start[i][j] != finish[i][j]) {
				cout << "-1" << endl;
				return 0;
			}
		}
	}

	cout << res << endl;
	return 0;
}