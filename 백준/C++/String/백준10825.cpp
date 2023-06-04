#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n;

struct Person {
	string name;
	int kor, eng, math;
};


bool compare(Person a, Person b) {
	if (a.kor == b.kor && a.eng == b.eng && a.math == b.math) return a.name < b.name;
	else if (a.kor == b.kor && a.eng == b.eng) return a.math > b.math;
	else if (a.kor == b.kor) return a.eng < b.eng;
	else return a.kor > b.kor;
	return true;
}

int main() {
	cin >> n;
	vector <Person> stu(n);
	for (int i = 0; i < n; i++) {
		cin >> stu[i].name >> stu[i].kor >> stu[i].eng >> stu[i].math;
	}

	sort(stu.begin(), stu.end(), compare);

	for (int i = 0; i < n; i++) {
		cout << stu[i].name << "\n";
	}

}