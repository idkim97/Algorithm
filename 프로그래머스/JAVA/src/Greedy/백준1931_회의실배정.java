package Greedy;

import java.io.*;
import java.util.*;

public class 백준1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] time = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			time[i][0] = s;
			time[i][1] = e;
		}
		
		Arrays.sort(time,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		
		int cnt=0;
		int prev_end_time=0;
		
		for(int i=0;i<n;i++) {
			if(prev_end_time<=time[i][0]) {
				prev_end_time = time[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	
}
