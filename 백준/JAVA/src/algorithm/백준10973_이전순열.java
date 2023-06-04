package algorithm;

import java.io.*;
import java.util.*;

public class 백준10973_이전순열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(prevPermutation(arr)) {
			for(int i=0;i<n;i++) {
				System.out.print(arr[i] + " ");
			}
		}else {
			System.out.println("-1");
		}
		
	}
	
	public static boolean prevPermutation(int[] arr) {
		
		int a = arr.length-2;
		
		while(a>=0 && arr[a]<=arr[a+1]) a--;
		if(a<0) return false;
		
		int b = arr.length-1;
		while(arr[a]<arr[b]) b--;
		
		swap(arr,a,b);
		
		int start = a+1;
		int end = arr.length-1;
		
		while(start<end) swap(arr,start++,end--);
		
		
		
		return true;
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
