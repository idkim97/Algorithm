package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준10972_다음순열 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation(a)) {
			for(int i=0;i<n;i++) {
				System.out.print(a[i] + " ");
			}
		}else {
			System.out.println("-1");
		}
	}
	
	
	private static boolean nextPermutation(int[] a) {
		int i = a.length-1;
		
		// 감소하는 수열 인덱스 찾기
		while(i>0 && a[i-1] >=a[i]) {i--;}
		if(i<=0) return false;
		
		int j = a.length-1;
		// a[i-1] 보다 작은수중 제일 큰수 찾기
		while(a[j]<=a[i-1]) { j--; }
		
		swap(i-1,j,a);
		
		j = a.length-1;
		
		while(i<j) {
			swap(i,j,a);
			i++; j--;
		}
		
		return true;
	}
	
	private static void swap(int idx1, int idx2, int[] a) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;

		
	}
}
