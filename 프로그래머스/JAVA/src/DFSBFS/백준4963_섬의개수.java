package DFSBFS;

import java.io.IOException;
import java.util.Scanner;

public class 백준4963_섬의개수 {
	
	private static int w;
	private static int h;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1,-1,0,1,1,1,0,-1};
	private static int[] dy = {0,1,1,1,0,-1,-1,-1};
	private static int island;
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) break;

			map = new int[h][w];
			visited = new boolean[h][w];
			
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			island=0;
			
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						island++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(island);
		}
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&nx<h&&ny>=0&&ny<w) {
				if(!visited[nx][ny] && map[nx][ny]==1) {
					dfs(nx,ny);
				}
			}
		}
	}
}
