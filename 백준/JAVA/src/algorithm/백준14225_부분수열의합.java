package algorithm;

import java.io.*;
import java.util.*;
public class 백준14225_부분수열의합 {

    private static int n;
    private static int[] arr;
    private static HashSet<Integer> list = new HashSet<Integer>();
    private static int min=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0,0);

        while(list.contains(min)){
            min++;
        }
        System.out.println(min);






    }

    public static void dfs(int depth, int total){
        if(depth==n){
            list.add(total);
            return;
        }

        dfs(depth+1, total+arr[depth]);
        dfs(depth+1, total);
    }

}
