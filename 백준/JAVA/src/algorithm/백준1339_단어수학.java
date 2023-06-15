package algorithm;

import java.io.*;
import java.util.*;

public class 백준1339_단어수학 {

	private static int[] arr = new int[26];
	private static long res = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			int len = str.length();
			for(int j=0;j<len;j++) {
				char c = str.charAt(j);
				arr[c-'A'] += Math.pow(10, str.length()-(j+1));
			}
		}
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(arr2,Collections.reverseOrder());
		
		int num = 9;
		for(int i=0;i<10;i++) {
			res += (num-i)*arr2[i];
		}
		
		System.out.println(res);
		
	}
}
