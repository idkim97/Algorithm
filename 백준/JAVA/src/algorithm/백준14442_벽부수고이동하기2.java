package algorithm;

import java.io.*;
import java.util.*;

public class 백준14442_벽부수고이동하기2 {

    private static int n,m,k;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int res = Integer.MAX_VALUE;

    public static class Pair{
        int x;
        int y;
        int wall;
        int cnt;

        Pair(int x, int y, int wall, int cnt){
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k+1];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        int result = bfs();
        System.out.println(result);

    }

    public static int bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,0,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int curx = p.x;
            int cury = p.y;
            int curwall = p.wall;
            int curcnt = p.cnt;

            if(curx==n-1 && cury==m-1){
                return curcnt+1;
            }

            for(int i=0;i<4;i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    // 벽을 안부수는 경우
                    if(map[nx][ny]==0 && !visited[nx][ny][curwall]){
                        visited[nx][ny][curwall] = true;
                        q.offer(new Pair(nx,ny,curwall,curcnt+1));
                    }
                    else if(map[nx][ny]==1 && curwall<k && !visited[nx][ny][curwall+1]){
                        visited[nx][ny][curwall+1] = true;
                        q.offer(new Pair(nx,ny,curwall+1,curcnt+1));
                    }

                }
            }
        }

        return -1;
    }

}
