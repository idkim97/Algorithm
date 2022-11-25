#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#define MAX 20;

using namespace std;

string solution(string new_id) {
    string answer = "";

    for (int i = 0; i < new_id.length(); i++) {
        if (new_id[i] >= 'A' && new_id[i] <= 'Z') {
            new_id[i] = tolower(new_id[i]);
        }
    }

    for (int i = 0; i < new_id.length(); i++) {
        if ((new_id[i] >= 'a' && new_id[i] <= 'z') || (new_id[i] >= '0' && new_id[i] <= '9') || new_id[i] == '-' || new_id[i] == '_' || new_id[i] == '.')
            answer.push_back(new_id[i]);
    }

    for (int i = 1; i < answer.length();) {
        if (answer[i - 1] == '.' && answer[i] == '.') {
            answer.erase(answer.begin() + i);
            continue;
        }
        else i++;
    }

    if (answer[0] == '.') answer.erase(answer.begin());
    if (answer[answer.length() - 1] == '.') answer.erase(answer.end() - 1);

    if (answer.length() == 0) answer.push_back('a');
    if (answer.length() >= 16) {
        answer.erase(answer.begin() + 15, answer.end());
        if (answer[answer.length() - 1] == '.') {
            answer.erase(answer.end() - 1);
        }
    }

    if (answer.length() <= 2) {
        char temp;
        temp = answer[answer.length() - 1];
        while (answer.length() != 3) {
            answer.push_back(temp);
        }
    }




    return answer;
}