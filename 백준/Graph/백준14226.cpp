#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

int d[1001][1001]; // [화면][클립보드]
int s;


int main() {
	cin >> s;
	memset(d, -1, sizeof(d));
	queue <pair<int, int>> q;
	q.push(make_pair(1, 0));
	d[1][0] = 0;

	while (!q.empty()) {
		int dis = q.front().first;
		int clip = q.front().second;
		q.pop();

		if (s == dis) {
			cout << d[dis][clip] << endl;
			break;
		}

		// 화면에 있는 이모티콘을 모두 복사하여 클립보드에 저장
		if (d[dis][dis] == -1) {
			d[dis][dis] = d[dis][clip] + 1;
			q.push(make_pair(dis, dis));
		}

		// 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
		if (d[dis + clip][clip] == -1 && dis + clip <=s) {
			d[dis + clip][clip] = d[dis][clip] + 1;
			q.push(make_pair(dis+clip, clip));
		}

		// 화면에 있는 이모티콘 하나 삭제
		if (d[dis-1][clip] == -1 && dis >0) {
			d[dis-1][clip] = d[dis][clip] + 1;
			q.push(make_pair(dis-1, clip));
		}
	}
	
	return 0;
}