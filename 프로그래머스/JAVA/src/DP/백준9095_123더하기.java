package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준9095_123더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] d = new int[15];
		
		d[0]=1;
		d[1]=1;
		d[2]=2;
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j=3;j<=n;j++) {
				d[j] =d[j-1]+d[j-2]+d[j-3];				
			}
			System.out.println(d[n]);
		}
	}
}
