#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
string candy[50];
int test;
int result = 0;

int NumCandy() {
	int result = 1;
	for (int i = 0; i < test; i++) {
	int temp = 1;
		for (int j = 1; j < test; j++) {
			if (candy[i][j - 1] == candy[i][j]) temp++;
			else {
				result = max(temp, result);
				temp = 1;
			}
			result = max(temp, result);
		}
	}

	for (int i = 0; i < test; i++) {
		int temp = 1;
		for (int j = 1; j < test; j++) {
			if (candy[j][i] == candy[j - 1][i]) temp++;
			else {
				result = max(temp, result);
				temp = 1;
			}
		}
		result = max(temp, result);
	}

	return result;
}

int main() {
	int cnt = 0;
	cin >> test;

	int result = 0;

	for (int i = 0; i < test; i++) cin >> candy[i];

	for (int i = 0; i < test; i++) {
		for (int j = 1; j < test; j++) {
			swap(candy[i][j - 1], candy[i][j]);
			result = max(result, NumCandy());
			swap(candy[i][j - 1], candy[i][j]);

			swap(candy[j][i], candy[j - 1][i]);
			result = max(result, NumCandy());
			swap(candy[j][i], candy[j - 1][i]);
		}
	}

	cout << result << endl;


}
