package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		Stack<Character> stack = new Stack<>();
		while (true) {
			str = br.readLine();
			if (str.equals("."))
				break;
			int len = str.length();
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				}

				else if (str.charAt(i) == ')') {
					if (stack.empty() || stack.peek() != '(') {
						stack.push(str.charAt(i));
						break;
					}

					else
						stack.pop();
				}

				else if (str.charAt(i) == ']') {
					if (stack.empty() || stack.peek() != '[') {
						stack.push(str.charAt(i));
						break;
					}
					else
						stack.pop();
				}
			}

			if (stack.empty()) {
				System.out.println("yes");
			}
			else System.out.println("no");
			stack.clear();
		}
	}
}
