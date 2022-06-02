#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <map>
#include <unordered_map>
#include <set>

using namespace std;

// report���� �ߺ� ����
// �Ű��� �Ű������ ������ �޾ƿ�
// map<�Ű� ������ map<�ε���,Ƚ��>>, ����


vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    unordered_map <string, int> human; // human[���] = �׻���� �ε���
    unordered_map <string, set<string>> rep;// rep[�Ű���ѻ��][�Ű��ѻ���ε���] = �Ű���� Ƚ��


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