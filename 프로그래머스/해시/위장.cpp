#include <string>
#include <vector>
#include <map>

using namespace std;

// 종류별 의상이 몇개인지 파악

// 의상 종류가 3가지다
// 1가지만 입는경우 + 2가지만 입는경우 + 3가지 다입는경우
// 의상 종류가 n가지다
// 1가지만 입는경우 + 2가지만 입는경우 + .. + n가지 입는경우

int solution(vector<vector<string>> clothes) {
    int answer = 1;

    // map은 key-value pair를 가지고 오름차순 정렬됨, 중복 허용 x
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