#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int s[100][100]; // 능력치
vector <int> team1(n / 2); // team1이 될수있는 모든 경우의수
vector <int> team2(n / 2); // team2가 될수있는 모든 경우의수
vector <int> a(n); // 0,1
vector <int> d(n); // 1~n까지의 사람
int team1_sum;
int team2_sum;
int ans = 2147483647;



//팀배정
void team(int n) {

	do {
		for (int i = 0; i < n/2; i++) {
			if (a[i] == 1) team1.push_back(i+1);
			if (a[i] == 0) team2.push_back(i+1);
		}

		team1_sum = 0;
		team2_sum = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				if (i == j) continue;
				team1_sum += s[team1[i]][team1[j]];
				team2_sum += s[team2[i]][team2[j]];
			}
		}
		ans = min(ans, abs(team1_sum - team2_sum));

	} while (next_permutation(a.begin(), a.end()));

	cout << ans << endl;
}


int main() {
	// cin의 연산시간을 scanf만큼 줄여주기 위한 코드 2줄
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);


	cin >> n;



	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> s[i][j];
		}
	}


	for (int i = 0; i < n / 2; i++) {
		a.push_back(0);
	}
	for (int i = 0; i < n / 2; i++) {
		a.push_back(1);
	}

	team(n);



}