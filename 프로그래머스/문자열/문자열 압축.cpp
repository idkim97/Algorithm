#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.size();
    // i= 자르는 단위
    for (int i = 1; i <= s.size() / 2; i++) {
        string temp = "", a = "", b = "";
        int cnt = 1;
        a = s.substr(0, i);
        for (int j = i; j < s.size(); j += i) {
            b = s.substr(j, i);
            if (a == b) cnt++;
            else {
                if (cnt > 1) temp += to_string(cnt);
                temp += a;
                a = s.substr(j, i);
                cnt = 1;
            }
        }
        if (cnt > 1) temp += to_string(cnt);
        temp += a;
        if (answer > temp.size()) answer = temp.size();

    }
    return answer;
}