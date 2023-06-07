package algorithm;

import java.io.*;
import java.util.*;

public class 백준10829_차이를최대로{
	
	private static int maxRes = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		while(nextPermutation(nums)) {
			maxRes = Math.max(maxRes,calculate(nums,n));
		}
		System.out.println(maxRes);
		
	}
	
	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static boolean nextPermutation(int[] nums) {
		
		int a = nums.length-2;
		
		while(a>=0 && nums[a] >nums[a+1]) a--;
		
		if(a<0) return false;
		
		int b = nums.length-1;
		
		while(nums[a] > nums[b]) b--;
		
		swap(nums,a,b);
		
		int start = a+1;
		int end = nums.length-1;
		
		while(start<end) swap(nums,start++,end--);
		
		
		return true;
	}
	
	
	public static int calculate(int[] nums, int n) {
		int result = 0;
		for(int i=0;i<=n-2;i++) {
			result += Math.abs(nums[i]-nums[i+1]);
		}
		
		return result;
	}
}
