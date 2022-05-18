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

    // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
    cout << "Hello Cpp" << endl;

    return answer;
}