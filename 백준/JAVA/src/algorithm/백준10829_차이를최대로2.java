package algorithm;

import java.io.*;
import java.util.*;

public class 백준10829_차이를최대로2 {
	
	private static int[] nums;
	private static int n;
	private static boolean[] visited;
	private static int[] perm;
	private static int result=0;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[n];
		visited = new boolean[n];
		perm = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max);
		
		
	}
	
	public static void dfs(int depth) {
		if(depth == nums.length) {
			result = calculate(perm);
			max = Math.max(max, result);
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm[depth] = nums[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int calculate(int[] nums) {
		int res = 0;
		for(int i=0;i<=n-2;i++) {
			res += Math.abs(nums[i]-nums[i+1]);
		}
		return res;
	}
}
