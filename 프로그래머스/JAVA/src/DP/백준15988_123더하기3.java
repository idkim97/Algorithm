package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준15988_123더하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long mod = 1000000009L;

		long[] d = new long[1_000_001];

		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		int t = Integer.parseInt(br.readLine());

		for (int j = 4; j <= 1_000_000; j++) {
			d[j] = (d[j - 3] + d[j - 2] + d[j - 1]) % mod;
		}
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(d[n]);
		}
	}
}
