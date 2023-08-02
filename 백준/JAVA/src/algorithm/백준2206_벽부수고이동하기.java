package algorithm;

import java.io.*;
import java.util.*;
public class 백준2206_벽부수고이동하기 {

    private static int n,m;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx={-1,0,1,0};
    private static int[] dy={0,1,0,-1};

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        int res = bfs();
        System.out.println(res);




    }

    public static int bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,0,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int wall = p.wall;
            int cnt = p.cnt;

            if(x==n-1 && y==m-1){
                return cnt;
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && nx>=0 && ny<m){
                    // 벽을 뚫는 경우
                    if(!visited[nx][ny][wall+1] && map[nx][ny]==1 && wall==0){
                        visited[nx][ny][wall+1] = true;
                        q.offer(new Pair(nx,ny,wall+1,cnt+1));
                    }
                    // 벽을 안뚫는 경우
                    else if(!visited[nx][ny][wall] && map[nx][ny]==0){
                        visited[nx][ny][wall] = true;
                        q.offer(new Pair(nx,ny,wall,cnt+1));
                    }
                }
            }
        }
        return -1;
    }
}
