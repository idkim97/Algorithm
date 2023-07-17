package algorithm;

import java.io.*;
import java.util.*;

public class 백준1697_숨바꼭질 {

    private static int n, k;
    private static boolean[] visited = new boolean[100001];
    private static int[] num = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n, k);

    }

    public static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) {
                System.out.println(num[k]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 0) {
                    nx = x + 1;
                } else if (i == 1) {
                    nx = x - 1;
                } else {
                    nx = x * 2;
                }

                if(nx>=0 && nx<=100000 && !visited[nx]){
                    num[nx] = num[x]+1;
                    visited[nx] = true;
                    q.offer(nx);
                }
            }
        }
    }
}
