package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준14002_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[1001];
		int[] d = new int[1001];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j <= i; j++) {
				if (a[i] > a[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}

		int res = 0;

		for (int i = 0; i < n; i++) {
			if (res < d[i])
				res = d[i];
		}
		
		System.out.println(res);
		
		int temp=res;

		Stack<Integer> stack = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			if(d[i]==temp) {
				stack.push(a[i]);
				temp--;
			}
		}
		
		for (int i = res-1; i >=0; i--) {
			System.out.print(stack.get(i)+" ");
		}

		

	}
}
