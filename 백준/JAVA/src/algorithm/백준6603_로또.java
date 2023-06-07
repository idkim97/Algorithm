package algorithm;

import java.io.*;
import java.util.*;

public class 백준6603_로또 {

	private static int[] arr;
	private static int k;
	private static boolean[] visited;
	private static int[] per;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			arr = new int[k];
			visited = new boolean[k];
			per = new int[k];

			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			System.out.println();
		}
	}

	public static void dfs(int depth, int idx) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
					System.out.print(per[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				per[depth] = arr[i];
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
