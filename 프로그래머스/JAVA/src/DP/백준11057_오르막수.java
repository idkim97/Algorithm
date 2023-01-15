package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준11057_오르막수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] d = new int[1001][11];
		int mod = 10007;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<10;i++) {
			d[1][i]=1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					d[i][j] += (d[i-1][k])%mod;
				}
			}
		}
		
		int res = 0;
		
		for(int i=0;i<10;i++) {
			res += d[n][i]%mod;
		}
		
		System.out.println(res%mod);
	}
}
