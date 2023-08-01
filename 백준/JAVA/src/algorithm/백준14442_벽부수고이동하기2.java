package algorithm;

import java.io.*;
import java.util.*;

public class 백준14442_벽부수고이동하기2 {

    private static int[][] map;
    private static int res = Integer.MAX_VALUE;
    private static int n,m,k;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        dfs(0, map);


        if(res!=Integer.MAX_VALUE)
        System.out.println(res);
        else System.out.println("-1");


    }

    public static void dfs(int wall, int[][] newMap){
        if(wall==k){
            bfs(newMap);
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(newMap[i][j]==1){
                    newMap[i][j]=0;
                    dfs(wall+1, newMap);
                    newMap[i][j] = 1;
                }
            }
        }
    }

    public static void bfs(int[][] map){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0]=true;
        int[][] result = new int[n][m];

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            if(x==n-1 && y==m-1){
                res = Math.min(result[x][y]+1,res);

                return;
            }

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && map[nx][ny]==0){
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx,ny));
                        result[nx][ny] = result[x][y]+1;
                    }
                }
            }
        }
    }

}
