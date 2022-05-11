#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

using namespace std;

int n, k;
int value[50];
int answer = 0;

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> value[i];
    }

    int i = n - 1;
    while (k) {
        while (k - value[i] >= 0) {
            k -= value[i];
            answer++;
        }
        i--;
    }

    cout << answer << endl;

}