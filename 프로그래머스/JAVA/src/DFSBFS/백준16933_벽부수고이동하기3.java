package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준16933_벽부수고이동하기3 {
	
	public static int n;
	public static int m;
	public static int k;
	public static int[][] map = new int[1000][1000];
	public static boolean[][][][] visited = new boolean[1000][1000][11][2];
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int res;
	
	
	public static class Pair {
		int x;
		int y;
		int breakWall;
		int cnt;
		int day;
		
		Pair(int x, int y, int breakWall, int cnt, int day){
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.cnt = cnt;
			this.day = day;
		}
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0,0,1,0));
		visited[0][0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			if(x==n-1 && y==m-1) {
				res = p.cnt;
				return;
			}

			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==1) {
						if(p.cnt<k && p.day==0 && !visited[nx][ny][p.breakWall+1][p.day+1]) {
							q.offer(new Pair(nx,ny,p.breakWall+1,p.cnt+1,p.day+1));
							visited[nx][ny][p.breakWall+1][p.day+1] = true;
						}
						else if(p.cnt<k && p.day==1 && !visited[nx][ny][p.breakWall][p.day-1]) {
							q.offer(new Pair(nx,ny,p.breakWall,p.cnt+1,p.day-1));
							visited[nx][ny][p.breakWall][p.day-1] = true;
						}
					}
					else {
						if(p.day==0 && !visited[nx][ny][p.breakWall][p.day+1]) {
							q.offer(new Pair(nx,ny,p.breakWall,p.cnt+1,p.day+1));
							visited[nx][ny][p.breakWall][p.day+1] = true;
						}
						else if(p.day==1 && !visited[nx][ny][p.breakWall][p.day-1]) {
							q.offer(new Pair(nx,ny,p.breakWall,p.cnt+1,p.day-1));
							visited[nx][ny][p.breakWall][p.day-1] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		res = -1;
		bfs();
		System.out.println(res);
	}
}
