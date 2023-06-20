package algorithm;

import java.io.*;
import java.util.*;

public class 백준1182_부분수열의합2 {

    private static int n;
    private static int sum;
    private static boolean[] visited;
    private static int[] arr;
    private static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        if(sum==0) res--;
        System.out.println(res);

    }

    public static void dfs(int depth, int total){
        if(depth==n){
            if(sum ==total) res++;
            return;
        }

        dfs(depth+1, total+arr[depth]);
        dfs(depth+1, total);
    }
}
