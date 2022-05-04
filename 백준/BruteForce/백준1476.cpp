#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
	int e, s, m;
	int year = 0;
	int ecount = 0, scount = 0, mcount = 0;
	cin >> e >> s >> m;

	while (1) {
		year++;
		ecount++;
		scount++;
		mcount++;
		if (ecount > 15) ecount = 1;
		if (scount > 28) scount = 1;
		if (mcount > 19) mcount = 1;

		if (ecount == e && scount == s && mcount == m) {
			cout << year << endl;
			break;
		}
	}
}
