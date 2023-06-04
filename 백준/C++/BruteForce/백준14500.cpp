#include <iostream>


using namespace std;
int tet[501][501];

int main() {
	// cin�� ����ð��� scanf��ŭ �ٿ��ֱ� ���� �ڵ� 2��
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	int m;

	cin >> n;
	cin >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> tet[i][j];
		}
	}
	int max = 0;
	int temp = 0;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (j <= m - 3) { // �ѤѤѤ�
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i][j + 3];
				if (max < temp) max = temp;
			}
			if (i <= n - 3) { // ����
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 2][j] + tet[i + 3][j];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j] + tet[i + 1][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 2][j] + tet[i + 2][j + 1];
				if (max < temp) max = temp;
			}

			if (i <= n - 1 && j <= m - 2) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i + 1][j];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j + 1] + tet[i + 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i >= 2 && j <= m - 2) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i - 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 3 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i - 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 2) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i][j + 2] + tet[i + 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 2][j] + tet[i][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 2) { // ��
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 1][j + 1] + tet[i + 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ����
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 1][j + 1] + tet[i + 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i >= 2 && j <= m - 1) { // 
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i - 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 3 && j <= m - 1) { // ����
				temp = tet[i][j] + tet[i - 1][j] + tet[i - 1][j + 1] + tet[i - 2][j + 1];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 1) { // ����
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j + 1] + tet[i + 1][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 2 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i][j + 2];
				if (max < temp) max = temp;
			}
			if (i <= n - 2 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i + 1][j] + tet[i + 1][j + 1] + tet[i + 2][j];
				if (max < temp) max = temp;
			}
			if (i <= n - 1 && j <= m - 2) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i + 1][j + 1] + tet[i][j + 2];
				if (max < temp) max = temp;
			}
			if (i >= 2 && i <= n - 1 && j <= m - 1) { // ��
				temp = tet[i][j] + tet[i][j + 1] + tet[i - 1][j + 1] + tet[i + 1][j + 1];
				if (max < temp) max = temp;
			}
		}
	}

	cout << max << endl;

}