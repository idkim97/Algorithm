package algorithm;

import java.io.*;
import java.util.*;

public class 백준2529_부등호2 {
	
	private static int num;
	private static char[] boo;
	private static int[] arr; 
	private static boolean[] visited;
	private static int[] nextPermu;
	private static long min = 9876543210L;
	private static long max = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		boo = new char[num];
		arr = new int[10];
		visited = new boolean[num+1];
		nextPermu = new int[num+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			boo[i] = st.nextToken().charAt(0);
		}
		
		//num입력받은 만큼 시작 arr 설정
		for(int i=0;i<=9;i++) {
			arr[i] = i;
		}
		
		//0123..num까지의 배열의 다음순열로 부등호 체크
		for(int i=0;i<10-num;i++) {
			int[] temp = new int[num+1];
			for(int k=0;k<num+1;k++) {
				temp[k] = i+k;
			}
			dfs(0,temp);

		}
		

		System.out.println(max);
		String minstr = Long.toString(min);
		if(minstr.length()<num+1) {
			minstr = "0" + minstr;
		}
		System.out.println(minstr);
	}
	
	public static void dfs(int depth, int[] arr) {
		if(depth==num+1) {
			// 부등호 체크
			
			boolean flag = check(nextPermu);
			String str = "";
			if(flag) {
				// nextPermu의 값과 min,max비교
//				for(int i=0;i<nextPermu.length;i++) {
//					System.out.print(nextPermu[i]);
//				}
//				System.out.println();
				for(int i=0;i<nextPermu.length;i++) {
					str += Integer.toString(nextPermu[i]);
				}
				long temp = Long.parseLong(str);
				max = Math.max(max, temp);
//				System.out.println("max : " + max);
				min = Math.min(min, temp);
//				System.out.println("min : " + min);
			}
			
			return;
		}
		
//		for(int temp : arr) {
//			System.out.print(temp);
//		}
//		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				nextPermu[depth] = arr[i];
				dfs(depth+1,arr);
				visited[i] = false;
			}
		}
	}
	
	public static boolean check(int[] nextPermu) {
		
//		for(int i=0;i<nextPermu.length;i++) {
//			System.out.print(nextPermu[i]);
//		}
//		System.out.println();
		
		for(int i=0;i<boo.length;i++) {
			if(boo[i]=='>') {
				if(nextPermu[i]>nextPermu[i+1]) {
					continue;
				}
				else return false;
			}
			else {
				if(nextPermu[i]<nextPermu[i+1]) {
					continue;
				}
				else return false;
			}
		}
		return true;
	}
}
