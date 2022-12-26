package DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준15990_123더하기5 {
	static final long mod = 1000000009L;
	static final int limit = 100000;
	static long[][] d = new long[limit+1][4];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 10000; i++) {
			if (i >= 1) {
				d[i][1] = (d[i - 1][2] + d[i - 1][3]);
				if (i == 1)
					d[i][1] = 1;
			}
			if (i >= 2) {
				d[i][2] = (d[i - 2][1] + d[i - 2][3]);
				if (i == 2)
					d[i][2] = 1;
			}
			if (i >= 3) {
				d[i][3] = (d[i - 3][1] + d[i - 3][2]);
				if (i == 3)
					d[i][3] = 1;
			}

			d[i][1] %= mod;
			d[i][2] %= mod;
			d[i][3] %= mod;
		}


		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((d[n][1] + d[n][2] + d[n][3]) % mod);		
		}


	}
}
