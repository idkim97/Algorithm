package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11722_가장긴감소하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int res = 0;
		
		for(int i=0;i<n;i++) {
			if(res<dp[i]) res = dp[i];
		}
		
		System.out.println(res);
		
		
	}
}
