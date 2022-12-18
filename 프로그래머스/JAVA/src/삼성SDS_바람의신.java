import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;



public class 삼성SDS_바람의신 {
	
	static int map[][];
	static int tempMap[][];
	static int answer;
	static Vector<Integer> order= new Vector();
	static int UP=0;
	static int DOWN=1;
	static int LEFT=2;
	static int RIGHT=3;
	static int DIR_NUM=4;
	static int n;
	static int m;
	static int k;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int count=1;
		while(true) {
			if(count>T) break;
			
			answer=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			
			for(int i=0;i<n;i++) {
				String s = br.readLine();
				StringTokenizer st1 = new StringTokenizer(s," ");
				for(int j=0;j<m;j++) {
					map[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			
			Repetition(0, DIR_NUM, k);
			System.out.println("#"+count+" " +answer);
			
			count++;
		}
	}
	
	public static void Repetition(int depth, int n, int r) {
		if(depth==r) {
			int result = wind();
			if(answer<result) {
				answer = result;
			}
			return;
		}
		
		
		
		
		for(int i=0;i<n;i++) {
			order.add(i);
			Repetition(depth+1, n, r);
			order.remove(order.size()-1);
		}
	}
	
	public static int wind() {
		int result=0;
		tempMap = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<order.size();i++) {
			move(order.get(i));
		}
		
		for(int y=0;y<n;y++) {
			for(int x=0;x<m;x++) {
				if(result < tempMap[y][x]) {
					result = tempMap[y][x];
				}
			}
		}
		
		return result;
	}
	
	public static void move(int dir) {
		switch (dir) {
		case 0: {
			for (int x = 0; x < m; x++) {
				for (int y = n - 1; y > 0; y--) {
					if (tempMap[y][x] > 0) {
						int ny = y + dy[0];
						tempMap[ny][x] += tempMap[y][x];
						tempMap[y][x] = 0;
						break;
					}
				}
			}
			break;
		}
		
		case 1: {
			for (int x = 0; x < m; x++) {
	            for (int y = 0; y < n - 1; y++) {
	                if (tempMap[y][x] > 0) {
	                    int ny = y + dy[1];
	                    tempMap[ny][x] += tempMap[y][x];
	                    tempMap[y][x] = 0;
	                    break;
	                }
	            }
	        }
	        break;
		}
		
		case 2:{
			for (int y = 0; y < n; y++) {
	            for (int x = m - 1; x > 0; x--) {
	                if (tempMap[y][x] > 0) {
	                    int nx = x + dx[2];
	                    tempMap[y][nx] += tempMap[y][x];
	                    tempMap[y][x] = 0;
	                    break;
	                }
	            }
	        }
	        break;
		}
		
		case 3:{
			for (int y = 0; y < n; y++) {
	            for (int x = 0; x < m - 1; x++) {
	                if (tempMap[y][x] > 0) {
	                    int nx = x + dx[3];
	                    tempMap[y][nx] += tempMap[y][x];
	                    tempMap[y][x] = 0;
	                    break;
	                }
	            }
	        }
	        break;
		}

		}
	}
	
	
	
}
