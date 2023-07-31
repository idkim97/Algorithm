package algorithm;

import java.io.*;

public class 백준2138_전구와스위치 {

    private static int[] start1;
    private static int[] start2;
    private static int[] target;
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int res1 = 0;
    private static int res2 = 1;
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        start1 = new int[n];
        start2 = new int[n];
        target = new int[n];

        String s1 = br.readLine();
        for (int i = 0; i < n; i++) {
            start1[i] = s1.charAt(i) - '0';   // 첫번째 클릭 x
            start2[i] = s1.charAt(i) - '0';   // 첫번째 클릭 o
        }

        String s2 = br.readLine();
        for (int i = 0; i < n; i++) {
            target[i] = s2.charAt(i) - '0';
        }

        start2[0] = 1 - start2[0];
        start2[1] = 1 - start2[1];


        for (int i = 1; i < n; i++) {
            if (start1[i - 1] != target[i - 1]) {
                start1[i - 1] = 1 - start1[i - 1];
                start1[i] = 1 - start1[i];
                res1++;
                if (i != n - 1) {
                    start1[i + 1] = 1 - start1[i + 1];
                }
            }

            if (start2[i - 1] != target[i - 1]) {
                start2[i - 1] = 1 - start2[i - 1];
                start2[i] = 1 - start2[i];
                res2++;
                if (i != n - 1) {
                    start2[i + 1] = 1 - start2[i + 1];
                }
            }
        }

        if (start1[n - 1] != target[n - 1]) res1 = min;
        if (start2[n - 1] != target[n - 1]) res2 = min;

        if (res1 == min && res2 == min) {
            System.out.println(-1);
        } else {
            res = Math.min(res1, res2);
            System.out.println(res);
        }
    }
}






