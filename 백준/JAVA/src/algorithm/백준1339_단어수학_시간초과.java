package algorithm;

import java.io.*;
import java.util.*;

public class 백준1339_단어수학_시간초과 {
	
	private static int[] arr;
	private static int n;
	private static ArrayList<String> alpha = new ArrayList<>();
	private static boolean[] check;
	private static char[] allAlpha = {'A','B','C','D','E','F','G','H','I',
	                           'J','K','L','M','N','O','P','Q','R',
	                           'S','T','U','V','W','X','Y','Z'};
	private static int count = 0;	// 알파벳 개수
	private static char[] useAlpha;
	private static boolean[] visited;
	private static int[] perm;
	private static long max = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		check = new boolean[26];
		
		for(int i=0;i<n;i++) {
			alpha.add(br.readLine());
		}
		
		// 알파벳 개수 세기
		for(int i=0;i<alpha.size();i++) {
			for(int j=0;j<alpha.get(i).length();j++) {
				int idx = alpha.get(i).charAt(j)-'A';
				check[idx] = true;
			}
		}
		
		for(int i=0;i<26;i++) {
			if(check[i]==true) count++;
		}
		
		arr = new int[count];
		useAlpha = new char[count];
		visited = new boolean[count];
		perm = new int[count];
		
		// 알파벳 갯수만큼 배열 선언
		for(int i=0;i<count;i++) {
			arr[i] = i+(10-count);
//			System.out.print(arr[i]+" ");
		}
		
		int idx=0;
		
		// 사용된 알파벳 선언
		for(int i=0;i<26;i++) {
			if(check[i]) {
				useAlpha[idx] = allAlpha[i];
				idx++;
			}
		}

		dfs(0);
		
		System.out.println(max);
	}
	
	
	public static void dfs(int depth) {
		
		
		if(depth==count) {
			long temp = calculate(perm);
			max = Math.max(temp, max);
			return;
			
		}
		
		for(int i=0;i<count;i++) {
			if(!visited[i]) {
				visited[i] = true;
				perm[depth] = arr[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
		
	}
	
	
	public static long calculate(int[] perm) {
		long temp = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<alpha.get(i).length();j++) {	// 
				for(int k=0;k<count;k++) {
					if(useAlpha[k]==alpha.get(i).charAt(j)) {
						temp += perm[k]*Math.pow(10,(alpha.get(i).length()-j-1));
					}
				}
			}
		}
		return temp;
	}
}
