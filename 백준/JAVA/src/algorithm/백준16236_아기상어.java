package algorithm;

import java.io.*;
import java.util.*;

public class 백준16236_아기상어 {

    private static int n;
    private static int[][] map;

    private static int sharkX, sharkY;

    private static int res=0;
    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {1,0,-1,0};


    public static class Pair {
        int x;
        int y;
        int time;

        Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        // 아기상어크기 : 2
        // 자기보다 큰 물고기는 지나갈수 없음
        // 같거나 작은 물고기는 지나갈수 있음
        // 근데 먹는거는 자기보다 작은 물고기만 먹을 수 있음
        // 가까운 물고기부터 먹음 근데 최소거리로 이동해야됨
        // 가까운 물고기가 여러마리면 위왼쪽 순서로 먹음
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sharkX, sharkY, 0));

        int age = 2;
        int time = 0;
        int eat = 0;

        while(true) {
            ArrayList<Pair> fish = new ArrayList<>();
            int[][] visited = new int[n][n];
            while (!q.isEmpty()) {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (map[nx][ny] <= age && visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + 1;
                            q.offer(new Pair(nx, ny, visited[nx][ny]));
                            if (map[nx][ny] < age && map[nx][ny] >= 1 && map[nx][ny] <= 6) {
                                fish.add(new Pair(nx, ny, visited[nx][ny]));
                            }
                        }
                    }
                }
            }

            if(fish.size()==0) return time;

            Pair curFish = fish.get(0);

            for(int i=1;i<fish.size();i++){
                if(curFish.time > fish.get(i).time){
                    curFish = fish.get(i);
                }
                else if(curFish.time == fish.get(i).time){
                    if(curFish.x>fish.get(i).x){
                        curFish = fish.get(i);
                    }
                    else if(curFish.x == fish.get(i).x){
                        if(curFish.y > fish.get(i).y) curFish = fish.get(i);
                    }
                }
            }

            time += curFish.time;
            eat++;
            map[curFish.x][curFish.y] = 0;
            if(eat==age){
                age++;
                eat=0;
            }
            q.offer(new Pair(curFish.x, curFish.y, 0));


        }


    }


}
