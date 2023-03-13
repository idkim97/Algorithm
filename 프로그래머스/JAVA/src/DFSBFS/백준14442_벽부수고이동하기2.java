package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준14442_벽부수고이동하기2 {
	
	public static int n;
	public static int m;
	public static int k;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	
	
	public static class Pair{
		int x;
		int y;
		int breakWall;
		int cnt;
		
		Pair(int x, int y, int breakWall, int cnt){
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.cnt = cnt;
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m][k+1];
		
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		bfs();
		
		
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0,0,1));
		visited[0][0][0]=true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.x==n-1 && p.y==m-1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int breakWall = p.breakWall;
				int cnt = p.cnt;
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					// 벽일때
					if(map[nx][ny]==1) {
						if(!visited[nx][ny][breakWall+1] && breakWall<k) {
							visited[nx][ny][breakWall+1] = true;
							q.offer(new Pair(nx,ny,breakWall+1,cnt+1));
						}
					}
					// 벽이 아닐때
					else {
						if(!visited[nx][ny][breakWall]) {
							visited[nx][ny][breakWall] = true;
							q.offer(new Pair(nx,ny,breakWall,cnt+1));
						}
					}
				}
			}
		}
		System.out.println("-1");
		
	}
}
