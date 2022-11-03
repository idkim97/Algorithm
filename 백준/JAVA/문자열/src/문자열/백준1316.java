package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1316 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int res = n;
		
		for(int i=0; i<n;i++) {
			String str = br.readLine();
			
			int[] check = new int[26];
			for(int j=0;j<26;j++) {
				check[j]=0;
			}
			for(int j=0;j<str.length();j++) {
				if(check[str.charAt(j)-'a']==1) {
					if(str.charAt(j-1)==str.charAt(j)) {
						continue;
					}
					else {
						res--;
						break;
					}
				}
				else check[str.charAt(j)-'a']++;					
			}
		}
		
		System.out.println(res);
	}
}
