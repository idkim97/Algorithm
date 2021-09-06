#include <iostream>
#include <stack>
#include <vector>
#define MAX 1000001

using namespace std;
using std::endl;
using std::cin;
using std::cout;

int main() {
	int num;
	cin >> num;

	vector <int> arr(num), ans(num, -1);
	vector <int> temp(MAX, 0);
	stack <pair<int, int>> st;

	for (int i = 0; i < num; i++) {
		cin >> arr[i];
		temp[arr[i]]++;
	}


	for (int i = num; i >= 0; i--) {
		while (!st.empty() && st.top().first <= temp[arr[i]]) {
			st.pop();
		}
		ans[i] = st.empty() ? -1 : st.top().second;
		st.push({ temp[arr[i]],arr[i] });
	}

	for (int i = 0; i < num; i++) cout << ans[i] << " ";
}