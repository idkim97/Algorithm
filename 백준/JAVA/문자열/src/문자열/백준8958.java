package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			int res=0;
			int cur=0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					cur+=1;
					res+=cur;
				}
				else {
					cur=0;
				}
			}
			System.out.println(res);
		}
		
	}
}
