package algorithm;

import java.io.*;
import java.util.*;

public class 백준16928_데스나이트 {

    private static int[] dx = {-2, -2, 0, 0, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -1, 1};
    private static int n,r1,c1,r2,c2;
    private static boolean[][] visited;
    private static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];
        cnt = new int[n][n];

        bfs();
    }

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void bfs() {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(r1,c1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            if(x==r2 && y==c2) {
                System.out.println(cnt[r2][c2]);
                return;
            }

            for(int i=0;i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    if(!visited[nx][ny]){
                        visited[nx][ny]=true;
                        cnt[nx][ny] = cnt[x][y] + 1;
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }

        System.out.println("-1");
    }
}
