#include <iostream>
#include <string>
#include <stack>
#include <vector>


using namespace std;
using std::endl;
using std::cin;
using std::cout;
const int MAX = 26;
double alpha[MAX];


int main() {
	int test;
	cin >> test;

	string str;
	cin >> str;

	stack <double> st;

	for (int i = 0; i < test; i++) {
		cin >> alpha[i];
	}


	for (int i = 0; i < str.size(); i++) {
	/*	if (str[i] != '*' || str[i] != '/' || str[i] != '+' || str[i] != '-') {
			st.push(alpha[str[i] - 'A']);
		}*/
		if (str[i] == '*') {
			double temp1 = st.top();
			st.pop();
			double temp2 = st.top();
			st.pop();
			double temp3 = temp1 * temp2;
			st.push(temp3);
		}
		else if (str[i] == '/') {
			double temp1 = st.top();
			st.pop();
			double temp2 = st.top();
			st.pop();
			double temp3 = temp2 / temp1;
			st.push(temp3);
		}
		else if (str[i] == '+') {
			double temp1 = st.top();
			st.pop();
			double temp2 = st.top();
			st.pop();
			double temp3 = temp1 + temp2;
			st.push(temp3);
		}
		else if (str[i] == '-') {
			double temp1 = st.top();
			st.pop();
			double temp2 = st.top();
			st.pop();
			double temp3 = temp2 - temp1;
			st.push(temp3);
		}

		else {
			st.push(alpha[str[i] - 'A']);
		}
	}



	double res = st.top();
	cout << fixed;
	cout.precision(2);
	cout << res << endl;

	return 0;
}