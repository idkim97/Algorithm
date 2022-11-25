#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map <string, int> music; // �帣�� ���Ƚ�� ����
    map <string, map<int, int>> mlist; // �帣�� �����뷡�� ��� ��ȴ���

    for (int i = 0; i < genres.size(); i++) {

        music[genres[i]] += plays[i];
        mlist[genres[i]][i] = plays[i];
    }

    while (music.size() > 0) {
        int max = 0;
        string genre = "";
        for (auto mu : music) {
            if (mu.second > max) {
                max = mu.second;
                genre = mu.first;
            }
        }

        for (int i = 0; i < 2; i++) {
            int val = 0;
            int idx = -1;
            for (auto ml : mlist[genre]) {
                if (ml.second > val) {
                    val = ml.second;
                    idx = ml.first;
                }
            }
            if (idx == -1) break;

            answer.push_back(idx);
            mlist[genre].erase(idx);
        }
        music.erase(genre);
    }
    return answer;
}