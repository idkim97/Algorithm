package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준11720 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();
		
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			sum += str.charAt(i)-'0';
		}
		
		System.out.println(sum);
		
	}
}
