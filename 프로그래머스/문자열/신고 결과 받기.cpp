#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <map>
#include <unordered_map>
#include <set>

using namespace std;

// report에서 중복 없애
// 신고자 신고당한자 나눠서 받아와
// map<신고 당한자 map<인덱스,횟수>>, 저장


vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    unordered_map <string, int> human; // human[사람] = 그사람의 인덱스
    unordered_map <string, set<string>> rep;// rep[신고당한사람][신고한사람인덱스] = 신고당한 횟수


    for (int i = 0; i < id_list.size(); i++) {
        human[id_list[i]] = i;
    }

    stringstream ss;
    for (auto re : report) {
        ss.str(re);
        string first, second;
        ss >> first >> second;
        rep[second].insert(first);
        ss.clear();
    }

    for (auto it : rep) {
        if (it.second.size() >= k) {
            for (auto iter : it.second) {
                answer[human[iter]]++;
            }
        }
    }


    return answer;
}