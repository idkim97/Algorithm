package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ����10972_�������� {
	
	
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
		
		// �����ϴ� ���� �ε��� ã��
		while(i>0 && a[i-1] >=a[i]) {i--;}
		if(i<=0) return false;
		
		int j = a.length-1;
		// a[i-1] ���� �������� ���� ū�� ã��
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
