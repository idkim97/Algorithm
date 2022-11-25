#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for (int a = 0; a < commands.size(); a++) {
        int i = commands[a][0] - 1;
        // cout << i;
        int j = commands[a][1];
        // cout << j;
        int k = commands[a][2] - 1;
        // cout << k;
        vector<int> temp;
        for (int p = i; p < j; p++) {
            temp.push_back(array[p]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[k]);
    }

    return answer;
}