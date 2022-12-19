import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성SDS_케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int count=1;
		
		while(true) {
			if(count>T) break;
			int N = Integer.parseInt(br.readLine());
			
			int[] a = new int[N]; // 존 배열
			int[] b = new int[N]; // 클로이 배열
			int[] d1= new int[N]; // N번인덱스로 끝나는 가장 큰 연속합 + 연속합의 변경유무 
			int[] d2= new int[N]; // 존 오른쪽 연속합 배열
			int[] d3= new int[N]; // 클로이 왼쪽 연속합 배열
			int[] d4= new int[N]; // 클로이 오른쪽 연속합 배열
			int[] result = new int[N]; // 최종 연속합 배열

			
			String john = br.readLine(); // 존 배열 받기
			StringTokenizer st1 = new StringTokenizer(john, " ");
			for(int i=0;i<N;i++) {
				a[i] = Integer.parseInt(st1.nextToken()); 
			}
			
			String cloye = br.readLine(); // 클로이 배열 받기
			StringTokenizer st2 = new StringTokenizer(cloye," ");
			for(int i=0;i<N;i++) {
				b[i] = Integer.parseInt(st2.nextToken());
			}
			
			// 존의 처음부터 마지막-1번째 인덱스까지의 연속합
			d1[9]=0;
			for(int i=0;i<N-1;i++) {
				d1[i]=a[i];
				if(i==0) continue;
				if(d1[i]<d1[i-1]+a[i]) {
					d1[i]=d1[i-1]+a[i];
				}
			}
			
			int max1 = -2100000000;
			for(int i=0;i<N;i++) {
				if(d1[i]>max1) max1=d1[i];
			}
			
			int max2 = -2100000000;
			for(int i=0;i<N;i++) {
				if(d2[i]>max2) max2=d2[i];
			}
			
			// 존의 두번째부터 마지막번쨰 인덱스 까지의 연속합
			d2[0]=0;
			for(int i=1;i<N;i++) {
				d2[i]=a[i];
				if(i==0) continue;
				if(d2[i]<d2[i-1]+a[i]) {
					d2[i]=d2[i-1]+a[i];
				}
			}
			
			
			
			count++;
			T--;
		}
	}
}
