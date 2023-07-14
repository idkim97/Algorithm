package algorithm;

import java.io.*;
import java.util.*;

public class 백준14502_연구소 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static ArrayList<Pair> virus = new ArrayList<Pair>();
    private static int wall=0;
    private static int res = Integer.MIN_VALUE;

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

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Pair(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(res);
    }

    public static void dfs(int wall){

        if(wall==3){
            bfs();
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(wall+1);
                    map[i][j]=0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        int[][] newMap = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                newMap[i][j] = map[i][j];
            }
        }

        for(int i=0;i<virus.size();i++){
            q.offer(virus.get(i));
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (newMap[nx][ny] == 0) {
                        newMap[nx][ny] = 2;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        int temp = countMap(newMap);
        if(res<temp) res = temp;


    }

    public static int countMap(int[][] newMap){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(newMap[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}
