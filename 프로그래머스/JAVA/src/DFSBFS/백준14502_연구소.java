package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준14502_연구소 {

	public static int n;
	public static int m;
	public static int[][] map = new int[9][9];
	public static boolean[][] visited = new boolean[9][9];
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int maxSafe = Integer.MIN_VALUE;

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(maxSafe);
	}
	
	// 벽을 3개 설치
	public static void dfs(int wall) {
		if(wall==3) {
			bfs();
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(wall+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		
		// 바이러스인 지점 queue에 저장
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==2) {
					q.offer(new Pair(i,j));
				}
			}
		}
		
		int[][] newMap = new int[9][9];
		
		// 복사한 맵
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m) {
					if(newMap[nx][ny]==0) {
						newMap[nx][ny] = 2;
						q.offer(new Pair(nx,ny));
					}
				}
			}
		}
		
		countSafe(newMap);
	}
	
	public static void countSafe(int[][] newMap) {
		int safe = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(newMap[i][j]==0) {
					safe++;
				}
			}
		}
		
		if(safe>maxSafe) maxSafe = safe;
	}
}
