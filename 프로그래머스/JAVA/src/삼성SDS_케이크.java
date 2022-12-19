import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �ＺSDS_����ũ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int count=1;
		
		while(true) {
			if(count>T) break;
			int N = Integer.parseInt(br.readLine());
			
			int[] a = new int[N]; // �� �迭
			int[] b = new int[N]; // Ŭ���� �迭
			int[] d1= new int[N]; // N���ε����� ������ ���� ū ������ + �������� �������� 
			int[] d2= new int[N]; // �� ������ ������ �迭
			int[] d3= new int[N]; // Ŭ���� ���� ������ �迭
			int[] d4= new int[N]; // Ŭ���� ������ ������ �迭
			int[] result = new int[N]; // ���� ������ �迭

			
			String john = br.readLine(); // �� �迭 �ޱ�
			StringTokenizer st1 = new StringTokenizer(john, " ");
			for(int i=0;i<N;i++) {
				a[i] = Integer.parseInt(st1.nextToken()); 
			}
			
			String cloye = br.readLine(); // Ŭ���� �迭 �ޱ�
			StringTokenizer st2 = new StringTokenizer(cloye," ");
			for(int i=0;i<N;i++) {
				b[i] = Integer.parseInt(st2.nextToken());
			}
			
			// ���� ó������ ������-1��° �ε��������� ������
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
			
			// ���� �ι�°���� ���������� �ε��� ������ ������
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
