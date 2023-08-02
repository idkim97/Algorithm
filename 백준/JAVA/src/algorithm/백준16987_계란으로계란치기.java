package algorithm;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class 백준16987_계란으로계란치기 {

    private static int n;
    private static int[] naegoo;
    private static int[] weight;
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        naegoo = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            naegoo[i] = a;
            weight[i] = b;
        }
    }

    public static void dfs(int idx) {
        if (idx == n - 1) {

            return;
        }

        if (naegoo[idx] > 0) {

        }
    }

}
