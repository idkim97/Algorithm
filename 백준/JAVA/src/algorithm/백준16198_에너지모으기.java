package algorithm;

import java.io.*;
import java.util.*;
public class 백준16198_에너지모으기 {

    private static int n;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0);

        System.out.println(max);

    }

    public static void dfs(int sum){
        if(list.size()<=2){
            if(max<sum) max = sum;
            return;
        }

        for(int i=1;i<list.size()-1;i++){
            int temp = list.get(i);
            list.remove(i);
            dfs(sum+list.get(i-1)*list.get(i));
            list.add(i,temp);
        }
    }
}
