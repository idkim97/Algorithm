package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ����1427 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// String�� char�迭�� �ٲ��ִ� �޼ҵ�
		char[] arr = str.toCharArray(); 
		
		// ��������
		Arrays.sort(arr);

		StringBuilder temp = new StringBuilder(new String(arr));
		
		String res = temp.reverse().toString();
		
		System.out.println(res);
	}
}
