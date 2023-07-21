package algorithm;

import java.io.*;
import java.util.*;

public class 백준2138_전구와스위치 {

    private static int[] start;
    private static int[] target;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        start = new int[n];
        target = new int[n];

        String temp = br.readLine();
        for (int i = 0; i < n; i++) {
            start[i] = temp.charAt(i) - '0';
        }

        String temp2 = br.readLine();
        for (int i = 0; i < n; i++) {
            target[i] = temp2.charAt(i) - '0';
        }


    }


}

