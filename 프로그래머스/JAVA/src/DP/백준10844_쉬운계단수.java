package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준10844_쉬운계단수 {
	static final long mod = 1000000000L;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] d = new long[101][10];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=9;i++) {
			d[1][i] = 1; 
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				if(j+1<=9) {
					d[i][j] += (d[i-1][j+1]%mod);
				}
				if(j-1>=0) {
					d[i][j] += (d[i-1][j-1]%mod);
				}
				
			}
		}
		long res=0;
		
		for(int i=0;i<=9;i++) {
			res += d[n][i];
		}
		
		System.out.println(res%mod);
	}
}
