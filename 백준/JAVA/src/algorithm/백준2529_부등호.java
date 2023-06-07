package algorithm;

import java.io.*;
import java.util.*;

public class 백준2529_부등호 {
	
	private static int n;
	private static char[] boo;
	private static int[] arr;
	private static boolean[] visited;
	private static int[] per;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		boo = new char[n]; 			// 부등호 배열
		arr = new int[n];			// 배열
		visited = new boolean[n];	// 방문 배열
		per = new int[n] 			// 배열 저장
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			boo[i] = st.nextToken().charAt(0);
		}
		
		// 10개의 숫자 중 n개를 뽑아서 순열 쭈루룩 나열
		
		dfs(0,0);
		
		//2
		//012~987
		
	}
	
	public static void dfs(int depth, int idx, int[] nums) {
		if(depth==n+1) {
			
		}
		
		for(int i=idx;i<=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				per[depth] = 
			}
		}
	}
}
