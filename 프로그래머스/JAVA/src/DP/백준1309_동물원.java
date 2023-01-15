package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1309_동물원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d[][] = new int[100001][3];
		int mod = 9901;
		int n = Integer.parseInt(br.readLine());
		
		d[1][0]=d[1][1]=d[1][2]=1;
		
		for(int i=2;i<=n;i++) {
			d[i][0] = (d[i-1][0]+d[i-1][1]+d[i-1][2])%mod;
			d[i][1] = (d[i-1][0] + d[i-1][2])%mod;
			d[i][2] = (d[i-1][0] + d[i-1][1])%mod;
		}
		
		int res = (d[n][0]+d[n][1]+d[n][2])%mod;
		
		System.out.println(res);
		
		
	}
}
