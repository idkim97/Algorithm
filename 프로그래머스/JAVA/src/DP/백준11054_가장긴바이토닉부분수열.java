package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[1001];
		int[] d1 = new int[1001];
		int[] d2 = new int[1001];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			d1[i]=1;
			for(int j=0;j<=i;j++) {
				if(a[i]>a[j] && d1[i]<d1[j]+1) {
					d1[i] = d1[j]+1;
				}
			}	
		}
		
		for(int i=n-1;i>=0;i--) {
			d2[i]=1;
			for(int j=i+1;j<n;j++) {
				if(a[i]>a[j] && d2[i]<d2[j]+1) {
					d2[i] = d2[j]+1;
				}
			}	
		}
		
		int res=0;
				
		for(int i=0;i<n;i++) {
			if(d1[i]+d2[i]-1>res) res = d1[i]+d2[i]-1;
		}
		
		System.out.println(res);
		
		
	}
}
