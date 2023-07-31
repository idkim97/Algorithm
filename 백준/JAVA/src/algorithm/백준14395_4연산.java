package algorithm;

import java.io.*;
import java.util.*;

public class 백준14395_4연산 {

    public static class Pair {
        long num;
        String history;

        Pair(long num, String history) {
            this.num = num;
            this.history = history;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Integer.parseInt(st.nextToken());
        long t = Integer.parseInt(st.nextToken());

        bfs(s, t);


    }

    public static void bfs(long s, long t) {
        String[] ops = {"*", "+", "-", "/"};
        HashSet<Long> set = new HashSet<Long>();
        Queue<Pair> q = new LinkedList<>();
        set.add(s);
        q.add(new Pair(s, ""));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            long nowNum = p.num;
            long next = nowNum;
            String nowHistory = p.history;

            if (s == t) {
                System.out.println(0);
                return;
            }

            if(nowNum==t){
                System.out.println(nowHistory);
                return;
            }

            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        next = nowNum*nowNum;
                        break;
                    case 1:
                        next = nowNum + nowNum;
                        break;
                    case 2:
                        next = nowNum - nowNum;
                        break;
                    case 3:
                        if (nowNum != 0) {
                            next = nowNum / nowNum;
                        }
                        break;
                }
                if (!set.contains(next)) {
                    set.add(next);
                    q.offer(new Pair(next, nowHistory + ops[i]));
                }

            }
        }

        System.out.println("-1");
    }


}

