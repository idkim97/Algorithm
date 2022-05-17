#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;


// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> data) {
    int answer = 0;

    vector <char> friends = { 'A','C','F','J','M','N','R','T' };

    do {
        bool flag = true;
        for (int i = 0; i < n; i++) {
            char first = data[i][0];
            char second = data[i][2];
            char op = data[i][3];
            int value = data[i][4] - '0';
            int friends1 = 0;
            int friends2 = 0;

            for (int j = 0; j < friends.size(); j++) {

                if (friends[j] == first) friends1 = j;
                if (friends[j] == second) friends2 = j;
            }

            int gap = abs(friends1 - friends2) - 1;

            if (op == '=') {
                if (gap != value) {
                    flag = false;
                    break;
                }
            }
            if (op == '<') {
                if (gap >= value) {
                    flag = false;
                    break;
                }
            }
            if (op == '>') {
                if (gap <= value) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) answer++;
    } while (next_permutation(friends.begin(), friends.end()));
    return answer;
}