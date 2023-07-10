package algorithm;

import java.io.*;
import java.util.*;
public class 백준14940_쉬운최단거리 {
    private static int n,m,targetX,targetY;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int[][] map;
    private static int[][] dis;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    targetX = i;
                    targetY = j;
                }
            }
        }

        bfs();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(targetX,targetY));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        visited[nx][ny]=true;
                        dis[nx][ny] = dis[x][y]+1;
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    dis[i][j] = -1;
                }
            }
        }
    }
}
