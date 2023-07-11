package algorithm;

import java.io.*;
import java.util.*;

public class 백준16234_인구이동 {

    private static int n, l, r;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int res = 0;

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
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;

        while(flag){
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j); // bfs 호출
                        flag |= check(); // flag 갱신
                    }
                }
            }
            visited = new boolean[n][n];
        }

        System.out.println(res);


    }

    public static void bfs(int x1, int y1) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x1, y1));
        visited = new boolean[n][n];
        visited[x1][y1] = true;
        int sum = 0, cnt = 0;
        boolean flag = false;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int temp = Math.abs(map[x][y] - map[nx][ny]);
                    if (!visited[nx][ny] && temp >= l && temp <= r) {
                        visited[nx][ny] = true;
                        flag = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    sum += map[i][j];
                    cnt++;
                }
            }
        }

        int temp = sum / cnt;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    map[i][j] = temp;
                }
                visited[i][j] = false;
                if (flag) System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        if (flag) res++;


    }

    // false면 bfs종료
    // true면 지속
    public static boolean check() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int temp = Math.abs(map[i][j] - map[i][j + 1]);
                int temp2 = Math.abs(map[i][j] - map[i + 1][j]);
                if ((temp >= l && temp <= r) || (temp2 >= l && temp2 <= r)) return true;
            }
        }
        return false;
    }
}
