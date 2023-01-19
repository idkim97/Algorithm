package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����2156_�����ֽý� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+2];
		int[] d = new int[n+2];
		
		for(int i=1;i<=n;i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		d[1]=a[1];
		d[2]=a[1]+a[2];
		
		for(int i=3;i<=n;i++) {
			d[i] = Math.max(d[i-1], Math.max(d[i-2]+a[i], d[i-3]+a[i-1]+a[i]));
		}
		
		System.out.println(d[n]);
	}
}
