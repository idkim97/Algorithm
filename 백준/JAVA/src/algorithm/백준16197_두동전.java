package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준16197_두동전 {

    private static int n;
    private static int m;
    private static char[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static ArrayList<Pair> list = new ArrayList<>();
    private static int res = Integer.MAX_VALUE;

    static class Pair {
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
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'o') {
                    list.add(new Pair(i, j));
                }
            }
        }

        dfs(list.get(0).x, list.get(0).y, list.get(1).x, list.get(1).y, 0);

        if (res == Integer.MAX_VALUE || res > 10) {
            res = -1;
        }

        System.out.println(res);
    }

    public static void dfs(int x1, int y1, int x2, int y2, int cnt) {
        if (cnt > 10) {
            return;
        }

        boolean coin1Dropped = isDropped(x1, y1);
        boolean coin2Dropped = isDropped(x2, y2);

        if (coin1Dropped && coin2Dropped) {
            return;
        }

        if (coin1Dropped || coin2Dropped) {
            if (res > cnt) {
                res = cnt;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];

            if (isOutOfBounds(nx1, ny1) && isOutOfBounds(nx2, ny2)) {
                continue;
            }

            if (isOutOfBounds(nx1, ny1) || isOutOfBounds(nx2, ny2)) {
                if (res > cnt + 1) {
                    res = cnt + 1;
                }
                continue;
            }

            if (map[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (map[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }

            dfs(nx1, ny1, nx2, ny2, cnt + 1);
        }
    }

    public static boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    public static boolean isDropped(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m || map[x][y] == '#';
    }
}
