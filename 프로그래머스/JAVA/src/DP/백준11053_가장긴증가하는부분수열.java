package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[1001];
		int[] d = new int[1001];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = st.countTokens();
		for (int i = 0; i < cnt; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			d[i] = 1;
			for(int j=0;j<=i;j++) {
				if(a[i]>a[j] && d[i]<d[j]+1) {
					d[i] = d[j]+1;
				}
			}
		}
		
		int res=0;
		
		for (int i = 0; i < cnt; i++) {
			if(res<d[i]) res = d[i];
		}
		
		System.out.println(res);
		
	}
}
