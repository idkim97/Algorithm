package Greedy;

import java.io.*;
import java.util.*;

public class 백준11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] money = new int[n];
		int res=0;
		
		for(int i=0;i<n;i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=n-1;i>=0;i--) {
			if(money[i]<=k) {
				res += (k/money[i]);
				k%=money[i];
			}
		}
		
		System.out.println(res);
	}
}
