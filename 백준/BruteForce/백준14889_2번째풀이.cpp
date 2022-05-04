#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#define MIN 2147483647;


using namespace std;

int n;
int arr[30][30];
vector <int> v;

int res;



int main() {
	scanf("%d", &n);
	res = MIN;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%d", &arr[i][j]);
		}
	}

	for (int i = 0; i < n / 2; i++) v.push_back(0); // startÆÀ
	for (int i = 0; i < n / 2; i++) v.push_back(1); // linkÆÀ

	do {
		vector <int> startteam;
		vector <int> linkteam;
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < n; i++) {
			if (v[i] == 0) {
				startteam.push_back(i + 1);
			}
			else linkteam.push_back(i + 1);
		}

		for (int i = 0; i < n/2; i++) {
			for (int j = i+1; j < n/2; j++) {
				if (i == j) continue;
				start += (arr[startteam[i]][startteam[j]] + arr[startteam[j]][startteam[i]]);
				link += (arr[linkteam[i]][linkteam[j]] + arr[linkteam[j]][linkteam[i]]);
			}
		}
		int temp = 0;

		temp = abs(start - link);
		res = min(res, temp);
		//printf("res : %d\n", res);
	} while (next_permutation(v.begin(), v.end()));

	printf("%d\n", res);


}