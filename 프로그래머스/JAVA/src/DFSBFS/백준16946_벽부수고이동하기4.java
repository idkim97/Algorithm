package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준16946_벽부수고이동하기4 {

	public static int n;
	public static int m;
	public static int[][] map = new int[1000][1000];
	public static int[][] group = new int[1000][1000];
	public static int[][] res = new int[1000][1000];
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int idx = 1;
	public static HashMap<Integer,Integer> hm = new HashMap<>();
	
	
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
		
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		

		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0 && group[i][j]==0) {
					hm.put(idx, bfs(i,j,idx));
					idx++;
				}
			}
		}
		
		/*
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					res[i][j] = countMap(i,j);
					System.out.print(res[i][j]);
				}
				else System.out.print(res[i][j]);
			}
			System.out.println();
		}
		*/
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(countMap(i,j));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	
		
		
	}
	
	public static int bfs(int curx, int cury, int idx) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(curx,cury));
		int cnt = 1;
		group[curx][cury]=idx;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==0 && group[nx][ny]==0) {
						q.offer(new Pair(nx,ny));
						group[nx][ny] = idx;
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static int countMap(int curx, int cury) {
		
		int sum = 1;
		HashSet<Integer> hs = new HashSet<>();
		
		if(map[curx][cury]==0) {
			return 0;
		}
		
		for(int i=0;i<4;i++) {
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(map[nx][ny]==0 && group[nx][ny]!=0) {
					hs.add(group[nx][ny]);
				}
			}
		}
		
		for(int idx : hs) {
			sum += hm.get(idx);
		}
		
		return sum%10;
	}
	
	
}
