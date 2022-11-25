#include <string>
#include <vector>
#include <map>

using namespace std;

// ������ �ǻ��� ����� �ľ�

// �ǻ� ������ 3������
// 1������ �Դ°�� + 2������ �Դ°�� + 3���� ���Դ°��
// �ǻ� ������ n������
// 1������ �Դ°�� + 2������ �Դ°�� + .. + n���� �Դ°��

int solution(vector<vector<string>> clothes) {
    int answer = 1;

    // map�� key-value pair�� ������ �������� ���ĵ�, �ߺ� ��� x
    map <string, int> list;

    for (int i = 0; i < clothes.size(); i++) {
        list[clothes[i][1]]++;
    }

    for (auto it : list) {
        answer *= (it.second + 1);
    }
    answer -= 1;

    return answer;
}