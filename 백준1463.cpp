#include <iostream>
#include <string>
#include <algorithm>


using namespace std;
using std::endl;
using std::cout;
using std::cin;

int dp[1000001];

int func(int num) {
	for (int i = 2; i <= num; i++) {
		dp[i] = dp[i - 1] + 1;
		if (i % 2 == 0)
			dp[i] = min(dp[i / 2] + 1, dp[i]);
		if (i % 3 == 0)
			dp[i] = min(dp[i / 3] + 1, dp[i]);
	}
	return dp[num];
}

int main() {

	int num;
	cin >> num;

	dp[1] = 0;


	cout << func(num) << endl;
	return 0;
}
