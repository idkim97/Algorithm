package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String vps = br.readLine();
			int left = 0;
			int right = 0;
			for (int j = 0; j < vps.length(); j++) {

				char temp = vps.charAt(j);
				if (temp == '(')
					left++;
				else if(temp==')')
					right++;

				if(right>left) {
					System.out.println("NO");
					break;
				}
			}
			if (left == right) {
				System.out.println("YES");
					
			}
			else if (left >right){
				System.out.println("NO");
				
			}
		}
	}
}
