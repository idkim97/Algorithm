package algorithm;

import java.io.*;
import java.util.*;

public class 백준7576_토마토 {

    private static int n, m, res;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static ArrayList<Pair> list = new ArrayList<Pair>();


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
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new Pair(i, j));
                }
            }
        }

        bfs();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j]==0){
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(res-1);

    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<Pair>();
        Queue<Pair> temp = new LinkedList<Pair>();

        int cnt = 0;

        for (int i = 0; i < list.size(); i++) {
            q.offer(list.get(i));
        }

        while (!q.isEmpty()) {

            int size = list.size();

            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        temp.offer(new Pair(nx, ny));
                    }
                }
            }
            cnt++;
//            System.out.println(cnt);
//            System.out.println(size);
            if (cnt == size) {
                while (!temp.isEmpty()) {
                    Pair pp = temp.poll();
                    q.offer(pp);
                    list.add(pp);
                }
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).x + " " + list.get(i).y);
//                }
//                System.out.println();
                res++;

                temp.clear();
            }

        }


    }
}
