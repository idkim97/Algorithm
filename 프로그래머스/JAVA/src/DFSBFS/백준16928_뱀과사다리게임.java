package DFSBFS;

import java.io.*;
import java.util.*;

public class 백준16928_뱀과사다리게임 {
	
	static class Pair {
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n,m;
		ArrayList<Pair> sadari = new ArrayList<Pair>();
		ArrayList<Pair> snake = new ArrayList<Pair>();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sadari.add(new Pair(x,y));
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			snake.add(new Pair(x,y));
		}
		
	}
}
