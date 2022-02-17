#include <iostream>
#include <vector>
using namespace std;

string a;
int BIT;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	int m = 20;
	int temp;

	while (n--) {
		cin >> a;
		if (a == "add") {
			cin >> temp;
			BIT = (BIT | 1 << temp);
		}
		else if (a == "remove") {
			cin >> temp;
			BIT = (BIT & ~(1 << temp));
		}
		else if (a == "check") {
			cin >> temp;
			if (BIT & (1 << temp)) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (a == "toggle") {
			cin >> temp;
			BIT = (BIT ^ (1 << temp));
		}
		else if (a == "all") {
			BIT = (1 << 21) - 1;
		}
		else if (a == "empty") {
			BIT = 0;
		}
	}

	return 0;
}