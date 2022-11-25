#include <string>
#include <vector>
#include <sstream>
#include <map>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    // 개행으로 구분
    // 첫번째 엔터,리브,체인지
    // 2,3번째 id-닉네임
    vector<string> state;
    map<string, string> user;


    for (int i = 0; i < record.size(); i++) {
        stringstream ss(record[i]);
        string temp;
        vector<string> log;
        while (ss >> temp) {
            log.push_back(temp);
        }
        if (log[0] == "Enter") {
            state.push_back("님이 들어왔습니다.");
            user[log[1]] = log[2];
            answer.push_back(log[1]);
        }
        else if (log[0] == "Leave") {
            state.push_back("님이 나갔습니다.");
            answer.push_back(log[1]);
        }
        else {
            user[log[1]] = log[2];
        }
    }

    for (int i = 0; i < answer.size(); i++) {
        answer[i] = user[answer[i]] + state[i];
    }
    return answer;
}