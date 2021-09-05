#include <iostream>
#include <stack>
#include <vector>

using namespace std;
using std::endl;
using std::cin;
using std::cout;

int main() {
	
	int test;
	int temp = 0;
	cin >> test;
	stack <int> st;
	vector <int> arr(test), ans(test,-1);

	for (int i = 0; i < test; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < test; i++) {
		while (!st.empty() && arr[st.top()] < arr[i]) {
			ans[st.top()] = arr[i];
			st.pop();
		}
		st.push(i);
	}

	for (int i = 0; i < test; i++) cout << ans[i] << " ";

	
	return 0;
}