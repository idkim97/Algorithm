package algorithm;

import java.io.*;
import java.util.*;

public class 백준14888_연산자끼워넣기 {

	static int n;
	static int[] arr;
	static int[] ops = new int[4];
	static char[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 배열입력받고
		// 연산자 순서대로 배열에 넣기
		// 연산자 순열로 돌려
		// 최소최대 구하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0],1);
		
		System.out.println(max);
		System.out.println(min);

	}

	public static void dfs(int num, int idx) {

		if (idx == n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (ops[i] == 0)
				continue;

			switch (i) {
			case 0:
				ops[i]--;
				dfs(num + arr[idx], idx+1);
				break;

			case 1:
				ops[i]--;
				dfs(num - arr[idx], idx+1);
				break;

			case 2:
				ops[i]--;
				dfs(num * arr[idx], idx+1);
				break;

			case 3:
				ops[i]--;
				dfs(num / arr[idx], idx+1);
				break;
			}
			
			ops[i]++;
		}
	}
}
