package algorithm;

import java.io.*;
import java.util.*;

public class 백준16928_뱀과사다리게임 {
    private static int n;
    private static int m;

    private static int[] move;
    private static boolean[] visited;
    private static int[] cnt = new int[101];




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        move = new int[101];
        visited = new boolean[101];

        for(int i=0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }

        bfs();
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        cnt[1] = 0;
        visited[1] = true;


        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur==100){
                System.out.println(cnt[cur]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int x = cur+i;
                // 뱀 또는 사다리인 경우
                if(x>100) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if (move[x] != 0) {
                    if (!visited[move[x]]) {
                        q.offer(move[x]);
                        visited[move[x]] = true;
                        cnt[move[x]] = cnt[cur] + 1;
                    }
                }
                else {
                    q.offer(x);
                    cnt[x] = cnt[cur]+1;
                }
            }

        }
    }


}
