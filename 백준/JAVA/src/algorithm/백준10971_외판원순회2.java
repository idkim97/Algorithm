package algorithm;

import java.io.*;
import java.util.*;

public class 백준10971_외판원순회2 {

	private static int[][] arr;
	private static int n;
	private static boolean[] visited;
	private static int[] permu;
	private static int[] nums;
	private static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		nums = new int[n];
		visited = new boolean[n];
		permu = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}

		dfs(0);

		// 0 1 2 3 -> arr[0][1] + arr[1][2] + arr[2][3] + arr[3][0]

		System.out.println(res);

	}

	public static void dfs(int depth) {
		if (depth == nums.length) {
			int min = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				if (arr[permu[i]][permu[i + 1]] == 0) {
                    return; // 0으로 가는 경로가 없으면 종료
                }
				min += arr[permu[i]][permu[i + 1]];
			}
			if (arr[permu[n - 1]][permu[0]] == 0) {
                return; // 마지막 도시에서 첫 도시로 가는 경로가 없으면 종료
            }
			min += arr[permu[n - 1]][permu[0]];
			res = Math.min(res, min);


			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permu[depth] = nums[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
