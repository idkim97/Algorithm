class Solution {
    public String solution(int a, int b) {
        // 윤년 = 2월 29일이 있는 날
        String answer = "";
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] date = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int day=0;
        for(int i=0;i<a-1;i++){
            day += month[i];
        }
        day += b-1;
        int temp = day%7;
        answer = date[temp];
        
        return answer;
    }
}