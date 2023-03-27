package DFSBFS;

import java.util.*;
import java.io.*;

public class 백준16954_움직이는미로탈출 {
	
	public static int dx[] = {-1,-1,0,1,1,1,0,-1,0};
	public static int dy[] = {0,1,1,1,0,-1,-1,-1,0};
	public static char map[][] = new char[8][8];
	public static boolean visited[][];
	public static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<8;i++) {
			String temp = br.readLine();
			for(int j=0;j<8;j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		

		boolean res = bfs();
		if(res==true) System.out.println("1");
		else System.out.println("0");


	}
	
	public static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void move() {
		for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }
	}
	
	public static boolean bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(7,0));
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				
				if(x==0 && y ==7) {
					return true;
				}
				
				for(int k=0;k<9;k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx>=0 && nx<8 && ny>=0 && ny<8) {
						if(map[nx][ny]=='.') {
							q.offer(new Pair(nx,ny));
						}
					}
				}	
			}
			move();
		}
		
		return false;
	}
}
