package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준2206_벽부수고이동하기 {

	public static int n;
	public static int m;
	public static int[][] map = new int[1000][1000];
	public static boolean[][] visited = new boolean[1000][1000];
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int minDis = Integer.MAX_VALUE;
	
	
	public static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
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
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		dfs(false);
		
		System.out.println(minDis);

	}
	
	public static void dfs(boolean flag) {
		
		if(flag) {
			bfs();
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					map[i][j]=0;
					flag = true;
					dfs(flag);
					map[i][j]=1;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0,0));
		
		int dis = 0;
		int[][] newMap = new int[1000][1000];
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
					if(newMap[nx][ny]==0 && visited[nx][ny]==false) {
						dis++;
						visited[nx][ny] = true;
						q.offer(new Pair(nx,ny));
					}
				}
			}
		}
		
		if(dis<minDis) minDis = dis;
	}
}
