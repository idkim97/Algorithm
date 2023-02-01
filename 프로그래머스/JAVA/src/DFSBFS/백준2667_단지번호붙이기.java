package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 백준2667_단지번호붙이기 {
	
	private static int[][] map = new int[25][25]; // 입력받은 지도
	private static boolean[][] visited = new boolean[25][25]; // 방문 여부
	private static int n;
	private static int dx[] = {-1,0,1,0};
	private static int dy[] = {0,1,0,-1};
	private static int apartNum = 0; // 아파트 단지 번호 수
	private static int[] aparts = new int[25*25]; // 아파트 단지마다 개수
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					apartNum++;
					dfs(i,j);
				}
			}
		}
		
		Arrays.sort(aparts);
		
		System.out.println(apartNum);
		
		for(int i=0;i<aparts.length;i++) {
			if(aparts[i]!=0) {
				System.out.println(aparts[i]);				
			}
		}
		
		
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		aparts[apartNum]++;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
}
