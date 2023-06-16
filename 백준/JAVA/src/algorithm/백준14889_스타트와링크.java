package algorithm;

import java.io.*;
import java.util.*;

public class 백준14889_스타트와링크 {

	public static int[][] arr;
	public static int n;
	public static boolean visited[];
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(min);
	}
	
	public static void dfs(int start, int depth) {
		if(depth==n/2) {
			calculate();
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1,depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void calculate() {
		int team_start=0;
		int team_link=0;
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(visited[i]==true && visited[j]==true) {
					team_start += arr[i][j];
					team_start += arr[j][i];
				}
				else if(visited[i]==false && visited[j]==false) {
					team_link += arr[i][j];
					team_link += arr[j][i];
				}
			}
		}
		
		int temp = Math.abs(team_start-team_link);
		if(temp==0) {
			min = 0;
			return;
		}
		min = Math.min(min, temp);
	}
}
