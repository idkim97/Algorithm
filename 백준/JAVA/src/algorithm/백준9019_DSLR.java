package algorithm;

import java.io.*;
import java.util.*;

public class 백준9019_DSLR {
    private static int n;
    private static ArrayList<Pair> list = new ArrayList<>();
    private static StringBuilder[] result = new StringBuilder[10000];
    private static boolean[] visited = new boolean[10000];

    public static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10000; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list.add(new Pair(num1, num2));

            visited[num1] = true;
            bfs(list.get(i));
        }

    }

    public static int D(int num) {
        int res = (num * 2) % 10000;
        return res;
    }

    public static int S(int num) {
        int res = num - 1;
        if (res < 0) return 9999;
        else return res;
    }

    public static int L(int num) {
        int a = num / 1000;
        int b = num / 100 % 10;
        int c = num / 10 % 10;
        int d = num % 10;
        int res = b * 1000 + c * 100 + d * 10 + a;
        return res;
    }

    public static int R(int num) {
        int a = num / 1000;
        int b = num / 100 % 10;
        int c = num / 10 % 10;
        int d = num % 10;
        int res = d * 1000 + a * 100 + b * 10 + c;
        return res;
    }

    public static void bfs(Pair pair) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(pair);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int start = p.start;
            int end = p.end;
            if(start==end){
                String str = result[start].toString();
                System.out.println(str);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int cur = 0;
                switch (i) {
                    case 0:
                        cur = D(start);
                        if(!visited[cur]) {
                            q.offer(new Pair(cur,end));
                            result[cur] = new StringBuilder(result[start]).append("D");
                        }
                        break;

                    case 1:
                        cur = S(start);
                        if(!visited[cur]) {
                            q.offer(new Pair(cur,end));
                            result[cur] = new StringBuilder(result[start]).append("S");
                        }
                        break;

                    case 2:
                        cur = L(start);
                        if(!visited[cur]) {
                            q.offer(new Pair(cur,end));
                            result[cur] = new StringBuilder(result[start]).append("L");
                        }
                        break;

                    case 3:
                        cur = R(start);
                        if(!visited[cur]) {
                            q.offer(new Pair(cur,end));
                            result[cur] = new StringBuilder(result[start]).append("R");
                        }
                        break;
                }
            }


        }
    }
}
