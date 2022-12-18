import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼성SDS_케이크_8점 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int count=1;
		
		while(true) {
			if(count>T) break;
			int N = Integer.parseInt(br.readLine());
			
			int[] a = new int[N];
			int[] b = new int[N];
			int[] d1= new int[N];
			int[] d2= new int[N];
			
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
			
			for(int i=0;i<N;i++) {
				d1[i]=a[i];
				if(i==0) continue;
				if(d1[i]<d1[i-1]+a[i]) {
					d1[i] = d1[i-1]+a[i];
				}
			}
			int ans1 = d1[0];
			for(int i=0;i<N;i++) {
				if(ans1<d1[i]) ans1=d1[i];
			}
			
			for(int i=0;i<N;i++) {
				d2[i]=b[i];
				if(i==0) continue;
				if(d2[i]<d2[i-1]+b[i]) {
					d2[i] = d2[i-1]+b[i];
				}
			}
			
			int ans2 = d2[0];
			for(int i=0;i<N;i++) {
				if(ans2<d2[i]) ans2=d2[i];
			}
			
			int max = ans1+ans2;
			
			System.out.println("#"+count+" "+max);
			
			count++;
			T--;
		}
    }

}
