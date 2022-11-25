#include <iostream>
#include <string>
#include <stack>
#include <vector>

using namespace std;

int solution(string s)
{
    int answer = -1;
    stack <char> str;


    for (int i = 0; i < s.size(); i++) {
        if (str.empty() || str.top() != s[i]) {
            str.push(s[i]);
        }
        else if (str.top() == s[i]) {
            str.pop();
        }
    }
    if (str.empty()) answer = 1;
    else answer = 0;

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "Hello Cpp" << endl;

    return answer;
}