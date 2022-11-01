package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			
			int r = Integer.parseInt(s[0]);
			String str = s[1];

			
			for(int j=0;j<str.length();j++) {
				for(int k=0;k<r;k++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
