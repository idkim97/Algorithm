#include <iostream>
#include <vector>

using namespace std;
int arr[10][10];
vector <pair<int, int>> blank;
int cnt = 0;
bool found = false;

bool check(pair<int, int> p) {
	int square_x = p.first / 3;
	int square_y = p.second / 3;

	for (int i = 0; i < 9; i++) {
		if (arr[p.first][i] == arr[p.first][p.second] && i!=p.second) return false;
		if (arr[i][p.second] == arr[p.first][p.second]&& i!=p.first) return false;
	}

	for (int i = square_x * 3; i < square_x * 3 + 3; i++) {
		for (int j = square_y * 3; j < square_y * 3 + 3; j++) {
			if (arr[p.first][p.second] == arr[i][j]) {
				if (i != p.first && j != p.second) return false;
			}
		}
	}
	return true;
}

void sudoku(int N) {
	if (N == cnt) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << arr[i][j] << " ";
			}
			cout << "\n";
		}
		found = true;
		return;
	}

	for (int i = 1; i <= 9; i++) {
		arr[blank[N].first][blank[N].second] = i;
		if (check(blank[N])) {
			sudoku(N + 1);
		}
		if (found) return;
	}
	arr[blank[N].first][blank[N].second] = 0;
	return;

}

int main() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 0) {
				cnt++;
				blank.push_back(make_pair(i, j));
			}
		}
	}

	sudoku(0);

}