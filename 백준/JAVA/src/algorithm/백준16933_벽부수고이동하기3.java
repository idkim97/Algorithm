package algorithm;

import java.io.*;
import java.util.*;

public class 백준16933_벽부수고이동하기3 {

    private static int n, m, k;
    private static int[][] map;
    private static boolean[][][][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int res = 0;

    public static class Pair {
        int x;
        int y;
        int wall;
        int cnt;
        int day; // 1인경우 낮, 0인경우 밤

        Pair(int x, int y, int wall, int cnt, int day) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k + 1][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        res = bfs();
        System.out.println(res);
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 0, 1, 1));
        visited[0][0][0][1] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int wall = p.wall;
            int cnt = p.cnt;
            int day = p.day;

            if (x == n - 1 && y == m - 1) {
                return cnt;
            }


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {

                    // 벽이 아닌경우
                    if (map[nx][ny]==0) {
                        // 낮인 경우
                        if (day==1 && !visited[nx][ny][wall][day-1]) {
                            visited[nx][ny][wall][day-1] = true;
                            q.offer(new Pair(nx, ny, wall, cnt + 1, day-1));
                        }
                        // 밤인 경우
                        else if(day==0 && !visited[nx][ny][wall][day+1]){
                            visited[nx][ny][wall][day+1] = true;
                            q.offer(new Pair(nx,ny,wall,cnt+1,day+1));


                        }
                    }

                    // 벽인 경우
                    else if(map[nx][ny]==1){
                        // 낮인 경우
                        if (day==1 && wall<k && !visited[nx][ny][wall+1][day-1]) {
                            visited[nx][ny][wall+1][day-1] = true;
                            q.offer(new Pair(nx, ny, wall+1, cnt + 1, day-1));
                        }
                        // 밤인 경우
                        else if(day==0 && wall <k && !visited[x][y][wall][day+1]){
                            visited[x][y][wall][day+1] = true;
                            q.offer(new Pair(x,y,wall,cnt+1,day+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
