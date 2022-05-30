#include <iostream>
#define MAX 1000001

using namespace std;

int n;
long long m;
long long tree[MAX];
long long maximum = 0;
long long res = 0;
long long ans = 0;


long long cut(long long tree[], long long mid) {
    long long temp = 0;
    for (int i = 0; i < n; i++) {
        if (tree[i] - mid >= 0) {
            temp += (tree[i] - mid);
        }
    }
    return temp;
}

int main() {

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> tree[i];
        if (maximum < tree[i]) maximum = tree[i];
    }

    long long low = 1;
    long long high = maximum;
    long long mid = 0;
    while (low <= high) {
        mid = (low + high) / 2;
        res = cut(tree, mid);
        // cout << "res : " << res << endl;
        if (res < m) {
            high = mid - 1;
        }
        else {
            low = mid + 1;
            // cout << "mid : " << mid << endl;
            ans = mid;
        }
    }

    cout << ans << endl;
}