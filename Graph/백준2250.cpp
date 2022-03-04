#include <iostream>

using namespace std;

struct tree {
	int left, right;
	int depth, order;
};

tree a[20000];
int cnt[20000];
int leftNode[20000];
int rightNode[20000];
int order = 0;

void inorder(int node, int depth) {
	if (node == -1) return;
	inorder(a[node].left, depth + 1);
	a[node].order = ++order;
	a[node].depth = depth;
	inorder(a[node].right, depth + 1);
}


int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int num, x, y;
		cin >> num >> x >> y;

		a[num].left = x;
		a[num].right = y;
		if (x != -1) cnt[x]++;
		if (y != -1) cnt[y]++;
	}

	int root = 0;
	for (int i = 1; i <= n; i++) {
		if (cnt[i] == 0)
			root = i;
	}

	inorder(root, 1);
	int maxdepth = 0;

	for (int i = 1; i <= n; i++) {
		int depth = a[i].depth;
		int order = a[i].order;
		if (leftNode[depth] == 0) {
			leftNode[depth] = order;
		}
		else {
			leftNode[depth] = min(leftNode[depth], order);
		}
		rightNode[depth] = max(rightNode[depth], order);
		maxdepth = max(maxdepth, depth);
	}

	int ans = 0;
	int ans_level = 0;
	for (int i = 1; i <= maxdepth; i++) {
		if (ans < rightNode[i] - leftNode[i] + 1) {
			ans = rightNode[i] - leftNode[i] + 1;
			ans_level = i;
		}
	}

	cout << ans_level << ' ' << ans << "\n";
	return 0;

}