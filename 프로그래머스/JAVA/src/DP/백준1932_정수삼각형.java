package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1932_정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		
		int[][] a = new int[n+1][n+1];
		int[][] d = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + a[i][j];
			}
		}
		
		int res = 0;
		
		for(int i=1;i<=n;i++) {
			if(d[n][i]>res) res = d[n][i];
		}
		
		System.out.println(res);
	}
}
