import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 삼성SDS_헨젤과그레텔 {
	
	static int[][] map;
//	static int[][] distance;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static int m;
	static int r;
	static int c;


	public static void main(String[] args) throws IOException {
		
		int[][] distance;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int count = 1;

		while (true) {
			if (count > t)
				break;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			
			map = new int[n][m]; // 입력받은 배열
			distance = new int[n][m]; // 최소거리 저장하는 배열
			
			for (int i = 0; i < n; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
					distance[i][j] = map[i][j];
				}
			}
			
			int dis = calculate(distance);
			// System.out.println("dis" + dis);

			visited = new boolean[n][m];
			visited[0][0] = true;
			bfs(0, 0,distance,dis);
			System.out.print("#"+count+" ");
			System.out.print(map[n-1][m-1]-1 + " ");
			System.out.println(calculate(distance));
			
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					System.out.print(distance[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			count++;
		}

	}

	public static void bfs(int x, int y, int[][] distance, int dis) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			distance[nowX][nowY] = 0;
			if(dis>calculate(distance)) {
				dis=calculate(distance);
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					System.out.print(distance[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			//int temp = calculate(distance);
			//System.out.println("temp : " + temp);
			//if(temp<dis) dis=temp;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
				if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
				
				q.add(new int[] {nextX,nextY});
				map[nextX][nextY] = map[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}
	
	public static int calculate(int[][] distance) {
		int res=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(distance[i][j]==0) continue;
				else {
					int temp = Math.abs(i-(r-1)) + Math.abs(j-(c-1));
					res+=temp;
				}
			}
		}
		return res;
	}
}
