#include <iostream>
#include <vector>
using namespace std;

int n;
vector <int> w;
int res = 0;
int temp_res = 0;


void go() {
	if (w.size() == 2) {
		if (res < temp_res) res = temp_res;
		return;
	}

	for (int i = 1; i < w.size()-1; i++) {
		temp_res = temp_res + w[i - 1] * w[i + 1];
		int select = w.at(i);
		w.erase(w.begin()+i);
		go();
		w.insert(w.begin() + i, select);
		temp_res = temp_res - w[i - 1] * w[i + 1];
	}
	
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		w.push_back(temp);
	}

	go();
	cout << res << endl;
}