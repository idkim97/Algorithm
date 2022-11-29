class Solution {
    public int solution(int[] dot) {
        
        int answer = 0;
        
        int num1 = dot[0];
        int num2 = dot[1];
        
        if(num1>0 && num2>0) answer=1;
        else if(num1<0 && num2>0) answer=2;
        else if(num1<0 && num2<0) answer=3;
        else if(num1>0 && num2<0) answer=4;
        
        return answer;
    }
}