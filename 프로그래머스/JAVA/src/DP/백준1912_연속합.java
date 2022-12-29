package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1912_연속합 {
	public static void main(String[] args) throws IOException {
		
		int[] a = new int[100001];
		int[] d = new int[100001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			d[i]=a[i];
			if(i==0) continue;
			if(a[i]<d[i-1]+a[i]) {
				d[i]=d[i-1]+a[i];
			}
		}
		
		int res = -1000*100000;
		
		for(int i=0;i<n;i++) {
			if(res<d[i]) res=d[i];
		}
		System.out.println(res);
		
	}
}
