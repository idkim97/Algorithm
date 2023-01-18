package DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����9465_��ƼĿ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[2][n+1];
			int[][] d = new int[n+1][3]; // i��°��ƼĿ���µ� j(0:�ȶ� / 1: �������� / 2: �Ʒ����E)�϶� ��ƼĿ �ִ�
			
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=1;j<=n;j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1;i<=n;i++) {
				d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
				d[i][1] = Math.max(d[i-1][2], d[i-1][0]) + a[0][i];
				d[i][2] = Math.max(d[i-1][1], d[i-1][0]) + a[1][i];
			}
			
			int res = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
			
			System.out.println(res);
			
			
			
		}
	}
}
