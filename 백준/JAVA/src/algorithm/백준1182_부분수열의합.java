package algorithm;

import java.io.*;
import java.util.*;
public class 백준1182_부분수열의합 {

    private static int n;
    private static int[] arr;
    private static int sum;
    private static boolean[] visited;
    private static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 부분 수열의 합이 sum이 되는 경우의 수
        // 부분 수열의 개수가 1개,2개,3개,...,n개인 경우를 전부 해보면됨

        for(int i=1;i<=n;i++){
            recursive(0,0,i);
        }

        System.out.println(res);

    }

    public static void recursive(int depth, int idx, int target){
        if(depth==target){
                calculate();
                return;
        }

        for(int i=idx;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                recursive(depth+1,i+1, target);
                visited[i] = false;
            }
        }
    }

    public static void calculate(){
        int temp = 0;

        for(int i=0;i<n;i++){
            if(visited[i]){
                temp += arr[i];
            }
        }
        if(temp==sum) {
            res++;
        }
    }

}
