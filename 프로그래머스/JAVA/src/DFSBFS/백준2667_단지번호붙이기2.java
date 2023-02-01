package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ����2667_������ȣ���̱�2 {
	
	private static int[][] map = new int[25][25]; // �Է¹��� ����
	private static boolean[][] visited = new boolean[25][25]; // �湮 ����
	private static int n;
	private static int dx[] = {-1,0,1,0};
	private static int dy[] = {0,1,0,-1};
	private static int apartNum = 0; // ����Ʈ ���� ��ȣ ��
	private static int[] aparts = new int[25*25]; // ����Ʈ �������� ����
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
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
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            }else{
                System.out.println(aparts[i]);
            }
        }
		
		
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		aparts[apartNum]++;
		
		if(!q.isEmpty()) {
			int curX = q.peek()[0];
			int curY = q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(map[nx][ny] ==1 && !visited[nx][ny]) {
						q.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						aparts[apartNum]++;
					}
				}
			}
		}
	}
}
