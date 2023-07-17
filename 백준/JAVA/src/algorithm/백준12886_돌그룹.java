package algorithm;

import java.io.*;
import java.util.*;

public class 백준12886_돌그룹 {

    private static int a, b, c;
    private static ArrayList<Integer> list = new ArrayList<>();

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

        a = Integer.parseInt(st.nextToken());
        list.add(a);
        b = Integer.parseInt(st.nextToken());
        list.add(b);
        c = Integer.parseInt(st.nextToken());
        list.add(c);

    }



    public static void func(ArrayList<Integer> list) {

    }
}
