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
			int[] d1= new int[N]; // 존 왼쪽 연속합 배열
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
			
			for(int i=1;i<N;i++) {
				result[i-1] = func(N,i,d1,d2,d3,d4,a,b);
			}
			
			int max = -2000000000;
			for(int i=0;i<N;i++) {
				if(max<result[i]) max=result[i];
			}
			
			System.out.println("#"+count+" "+max);
			
			count++;
			T--;
		}
	}
	
	public static int func(int N, int idx, int[] d1, int[] d2, int[] d3, int[] d4, int[] a, int[] b) {
		int res=0;
		
		int max1=-1001;
		for(int i=0;i<idx;i++) {
			d1[i]=a[i];
			if(i==0) continue;
			if(d1[i]<d1[i-1]+a[i]) {
				d1[i] = d1[i-1]+a[i];
			}
			if(max1<d1[i]) max1=d1[i];
		}
		
		int max2=-1001;
		for(int i=idx;i<N;i++) {
			d2[i]=a[i];
			if(i==idx) continue;
			if(d2[i]<d2[i-1]+a[i]) {
				d2[i] = d2[i-1]+a[i];
			}
			if(max2<d2[i]) max2=d2[i];
		}
		
			
		int max3=-1001;
		for(int i=0;i<N;i++) {
			d3[i]=b[i];
			if(i==0) continue;
			if(d3[i]<d3[i-1]+b[i]) {
				d3[i] = d3[i-1]+b[i];
			}
			if(max3<d3[i]) max3=d3[i];
		}
		
		int max4=-1001;
		for(int i=idx;i<N;i++) {
			d4[i]=b[i];
			if(i==idx) continue;
			if(d4[i]<d4[i-1]+b[i]) {
				d4[i] = d4[i-1]+b[i];
			}
			if(max4<d4[i]) max4=d4[i];
		}
		
		int temp1 = max1+max4;
		int temp2 = max2+max3;
		
		if(temp1>temp2) res = temp1;
		else res= temp2;
		
		return res;
	}
}
