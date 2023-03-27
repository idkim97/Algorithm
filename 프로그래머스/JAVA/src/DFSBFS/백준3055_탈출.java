package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준3055_탈출 {
	
	public static int r;
	public static int c;
	public static char map[][] = new char[50][50];
	public static int tempx;
	public static int tempy;
	public static Queue<Pair2> s = new LinkedList<>();
	public static Queue<Pair> water = new LinkedList<>();
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static boolean visited[][] = new boolean[50][50];
	public static int res=-1;
	
	public static class Pair{
		int x;
		int y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Pair2{
		int x;
		int y;
		int cnt;
		
		Pair2(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void bfs() {
		while(!s.isEmpty()) {
			
			int waterSize = water.size();
			for(int i=0;i<waterSize;i++) {
				Pair waterP = water.poll();
				int waterX = waterP.x;
				int waterY = waterP.y;
				
				for(int j=0;j<4;j++) {
					int nx = waterX + dx[j];
					int ny = waterY + dy[j];
					if(nx>=0 && nx<r && ny>=0 && ny<c) {
						if(map[nx][ny]=='.') {
							map[nx][ny]='*';
							water.offer(new Pair(nx,ny));
						}
					}
				}	
			}
			
			
			int sSize = s.size();
			for(int i=0;i<sSize;i++) {
				Pair2 p = s.poll();
				int x = p.x;
				int y = p.y;
				int cnt = p.cnt;
				
				
				for(int j=0;j<4;j++){
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx>=0 && nx<r && ny>=0 && ny<c) {	
						if(map[nx][ny]=='D') {
							res = cnt+1;
							return;
						}
						
						else if(map[nx][ny]=='.' && !visited[nx][ny]) {
							map[nx][ny]='S';
							visited[nx][ny]=true;
							s.offer(new Pair2(nx,ny,cnt+1));

						}
					}
				}
			}
			
		}

	}
	


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		for(int i=0;i<r;i++) {
			String temp = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='S') {
					s.offer(new Pair2(i,j,0));
				}
				if(map[i][j]=='*') {
					water.offer(new Pair(i,j));
				}
				
			}
		}
		
		bfs();
		
		if(res>0) System.out.println(res);
		else System.out.println("KAKTUS");
		

		
		// 물 : *
		// 돌 : X
		// 비어있는곳 : .
		// 비버 굴: D
		// 고슴도치 : S
		// 물은 매시간마다 확장된다.
		// 물은 비버 굴로는 확장되지 않는다.
		// 물이 찰 예정인곳으로 고슴도치는 이동할수 없다
		// S -> D
	}
}
