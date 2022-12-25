package DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ����11726_2xnŸ�ϸ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[1001];
		
		d[0]=1;
		d[1]=1;
		
		for(int i=2;i<=n;i++) {
			d[i] = (d[i-1]) + (d[i-2]);
			d[i] = d[i]%10007;
		}
		
		
		System.out.println(d[n]);
	}
}
