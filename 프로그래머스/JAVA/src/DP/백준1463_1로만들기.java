package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 

public class 백준1463_1로만들기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		
		int[] d = new int[1000001]; // d[n] = n을 만드는데 필요한 최소연산의 수
		
		d[1]=0;
		
		for(int i=2;i<=n;i++) {
			d[i] = d[i-1]+1;	// 1을 뺴는 경우
			
			if(i%2==0 && d[i]>d[i/2]+1) {
				d[i] = d[i/2]+1;
			}
			
			if(i%3==0 && d[i]>d[i/3]+1) {
				d[i] = d[i/3] +1;
			}
		}
		System.out.println(d[n]);
	
	}
}
