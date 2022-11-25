#include <string>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    // 작업별 남은 일수 계산
    // 순서대로 자기 자신보다 남은 일수가 적은 기능 배포
    vector<int> answer;

    queue <int> last;

    // 남은 일수 계산
    for (int i = 0; i < progresses.size(); i++) {
        int temp = 0;
        if ((100 - progresses[i]) % speeds[i] == 0) {
            temp = (100 - progresses[i]) / speeds[i];
        }
        else temp = (100 - progresses[i]) / speeds[i] + 1;
        last.push(temp);
    }

    while (!last.empty()) {
        int cnt = 1;
        int curr = last.front();
        last.pop();
        while (!last.empty() && curr >= last.front()) {
            cnt++;
            last.pop();
        }
        answer.push_back(cnt);
    }



    return answer;
}