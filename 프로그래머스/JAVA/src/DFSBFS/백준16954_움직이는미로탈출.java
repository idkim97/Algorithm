package DFSBFS;

import java.util.*;
import java.io.*;

public class 백준16954_움직이는미로탈출 {
	
	public static int dx[] = {-1,-1,0,1,1,1,0,-1};
	public static int dy[] = {0,1,1,1,0,-1,-1,-1};
	public static char map[][] = new char[8][8];
	public static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<8;i++) {
			String temp = br.readLine();
			for(int j=0;j<8;j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		res = 0;
		bfs();
		System.out.println(res);

	}
	
	public static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(7,0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			if(x==0 && y ==7) {
				res = 1;
			}
			
			for(int i=0;i<8;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
			}
		}
	}
}
