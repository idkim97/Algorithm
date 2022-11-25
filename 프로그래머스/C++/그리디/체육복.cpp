#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector <int> stu(n + 2, 0);
    // 0ÀÌ¸י 
    int answer = 0;

    for (int i = 0; i < lost.size(); i++) {
        stu[lost[i]] -= 1;
    }
    for (int i = 0; i < reserve.size(); i++) {
        stu[reserve[i]] += 1;
    }

    for (int i = 1; i <= n; i++) {
        if (stu[i] < 0) {
            if (stu[i - 1] == 1) {
                stu[i]++;
                stu[i - 1]--;
            }
            else if (stu[i + 1] == 1) {
                stu[i]++;
                stu[i + 1]--;
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        if (stu[i] >= 0) answer++;
    }

    return answer;
}