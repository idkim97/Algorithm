package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준16928_뱀과사다리게임 {
	
	public static int[] move = new int[101];
	public static boolean[] visited = new boolean[101];
	public static int[] count = new int[101];	// 각 지점 최소 방문횟수
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n,m;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n+m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move[x] = y;
		}
		

		
		bfs();
		
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		count[1]=0;
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==100) {
				System.out.println(count[cur]);
				return;
			}
			
			for(int i=1;i<7;i++) {
				int x = cur + i;
				if(x>100) continue;
				if(visited[x]) continue;
				visited[x] = true;
				
				if(move[x]!=0) {
					if(!visited[move[x]]) {
						q.offer(move[x]);
						visited[move[x]] = true;
						count[move[x]] = count[cur]+1;
					}
				}
				else {
					q.offer(x);
					count[x] = count[cur]+1;
				}
			}
		}
	}
}
