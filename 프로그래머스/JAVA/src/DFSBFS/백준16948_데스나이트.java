package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준16948_데스나이트 {
	
	public static int[] dx= {-2,-2,0,0,2,2};
	public static int[] dy= {-1,1,-2,2,-1,1};
	public static boolean[][] visited = new boolean[201][201];
	public static int r1,r2,c1,c2;
	public static int n;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		bfs();
	}
	
	public static class Pair{
		int x;
		int y;
		int cnt;
		
		Pair(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(r1,c1,0));
		visited[r1][c1] = true;

		while(!q.isEmpty()) {
			
			Pair p = q.poll();
			
			if(p.x==r2 && p.y==c2) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i=0;i<6;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				

				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(!visited[nx][ny]) {
						int ncnt = p.cnt +1;
						q.offer(new Pair(nx,ny,ncnt));
						visited[nx][ny] = true;
					}
				}
			}
		}
		System.out.println("-1");
	}
}
