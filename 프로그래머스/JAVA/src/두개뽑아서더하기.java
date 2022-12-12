import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int temp = numbers[i]+numbers[j];
                if(!arr.contains(temp)) arr.add(temp);
            }
        }
        Collections.sort(arr);
        
        int[] answer = new int[arr.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}