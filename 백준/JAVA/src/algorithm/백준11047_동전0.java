package algorithm;

import java.io.*;
import java.util.*;
public class 백준11047_동전0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int res = 0;

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx=arr.length-1;
        while(k>0){
            if(arr[idx]<=k) {
                k -= arr[idx];
                res++;
            }
            else{
                idx--;
            }
        }

        System.out.println(res);


    }
}
