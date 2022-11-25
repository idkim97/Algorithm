#include <string>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    // �۾��� ���� �ϼ� ���
    // ������� �ڱ� �ڽź��� ���� �ϼ��� ���� ��� ����
    vector<int> answer;

    queue <int> last;

    // ���� �ϼ� ���
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