import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class »ï¼ºSDS_ÇîÁ©°ú±×·¹ÅÚ_DFS {
	
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

			map = new int[n][m]; // ÀÔ·Â¹ÞÀº ¹è¿­
			

			for (int i = 0; i < n; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			
			
		}
		
		
	}
	
	public void dfs(int x, int y, int[][] map, int depth) {
		
	}
}
