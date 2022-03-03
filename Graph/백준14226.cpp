#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

int d[1001][1001]; // [ȭ��][Ŭ������]
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

		// ȭ�鿡 �ִ� �̸�Ƽ���� ��� �����Ͽ� Ŭ�����忡 ����
		if (d[dis][dis] == -1) {
			d[dis][dis] = d[dis][clip] + 1;
			q.push(make_pair(dis, dis));
		}

		// Ŭ�����忡 �ִ� ��� �̸�Ƽ���� ȭ�鿡 �ٿ��ֱ�
		if (d[dis + clip][clip] == -1 && dis + clip <=s) {
			d[dis + clip][clip] = d[dis][clip] + 1;
			q.push(make_pair(dis+clip, clip));
		}

		// ȭ�鿡 �ִ� �̸�Ƽ�� �ϳ� ����
		if (d[dis-1][clip] == -1 && dis >0) {
			d[dis-1][clip] = d[dis][clip] + 1;
			q.push(make_pair(dis-1, clip));
		}
	}
	
	return 0;
}