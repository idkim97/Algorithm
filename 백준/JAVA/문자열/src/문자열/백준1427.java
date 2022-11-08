package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 백준1427 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// String을 char배열로 바꿔주는 메소드
		char[] arr = str.toCharArray(); 
		
		// 오름차순
		Arrays.sort(arr);

		StringBuilder temp = new StringBuilder(new String(arr));
		
		String res = temp.reverse().toString();
		
		System.out.println(res);
	}
}
