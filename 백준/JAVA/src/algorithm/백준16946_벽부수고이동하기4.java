package algorithm;

import java.io.*;
import java.util.*;

public class 백준16946_벽부수고이동하기4 {

    private static int n, m;
    private static int[][] map;
    private static int[][] group;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] res;
    private static ArrayList<Pair> list = new ArrayList<>();
    private static HashMap<Integer, Integer> hm = new HashMap<>();

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        group = new int[n][m];
        res = new int[n][m];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    hm.put(idx, bfs(i, j, idx));
                    idx++;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(countMap(i,j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());


    }

    public static int bfs(int ii, int jj, int idx) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(ii, jj));
        int cnt = 1;
        group[ii][jj] = idx;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (group[nx][ny] == 0 && map[nx][ny] == 0) {
                        q.offer(new Pair(nx, ny));
                        group[nx][ny] = idx;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static int countMap(int X, int Y){

        if(map[X][Y]==0) return 0;

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<4;i++){
            int nx = X+dx[i];
            int ny = Y+dy[i];

            if(nx>=0 && nx<n &&ny>=0 && ny<m){
                if(group[nx][ny]!=0 && map[nx][ny]==0){
                    hs.add(group[nx][ny]);
                }
            }
        }
        int cnt = 1;

        for(int value : hs){
            cnt += hm.get(value);
        }

        return cnt%10;
    }
}
