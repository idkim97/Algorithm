package algorithm;

import java.io.*;
import java.util.*;

public class 백준10972_다음순열 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if(nextPermutation(arr)) {
			for(int i=0;i<n;i++) {
				System.out.print(arr[i] + " ");
			}
		}else {
			System.out.println("-1");
		}

	}

	public static boolean nextPermutation(int[] nums) {
		
		int a = nums.length-2;
		
		while(a>=0 && nums[a]>=nums[a+1]) a--;
		
		if(a<0) return false;
		
		int b = nums.length-1;
		
		while(nums[a]>nums[b]) b--;
		
		swap(nums,a,b);
		
		int start = a+1;
		int end = nums.length-1;
		
		while(start<end) swap(nums,start++,end--);
		
		return true;
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
