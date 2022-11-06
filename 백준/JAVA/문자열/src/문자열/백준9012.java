package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				char temp = str.charAt(j);
				if(temp=='(') stack.push('(');
				else if(!stack.empty() && temp==')') stack.pop();
				else if(stack.empty() && temp==')') {
					stack.push(')');
					break;
				}
			}
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
			stack.clear();

		}
	}
}
