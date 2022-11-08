package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준11721 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			if(count==10) {
				System.out.print("\n");
				count=0;
			}
			System.out.print(str.charAt(i));
			count++;
		}
		
	}
}
