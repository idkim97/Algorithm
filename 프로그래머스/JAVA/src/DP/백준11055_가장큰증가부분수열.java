package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11055_가장큰증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(dp[i]<dp[j]+arr[i] && arr[i]>arr[j]) dp[i] = dp[j]+arr[i];
			}
		}
		
		int res=0;
		for(int i=0;i<n;i++) {
			if(res<dp[i]) res= dp[i];
		}
		
		System.out.println(res);
	}
}
