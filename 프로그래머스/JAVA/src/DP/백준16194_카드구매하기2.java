package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준16194_카드구매하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[1001];
		int[] d = new int[1001];

		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=1;i<=n;i++) {
			p[i] = Integer.parseInt(st.nextToken());
			d[i]=1000*10000;
		}

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				d[i] = Math.min(d[i], d[i-j]+p[j]);
			}
		}
		
		System.out.println(d[n]);
	}
}
