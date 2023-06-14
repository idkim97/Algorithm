package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준2529_부등호3 {
    private static int num;
    private static char[] boo;
    private static boolean[] visited;
    private static int[] permutation;
    private static StringBuilder maxResult;
    private static StringBuilder minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        boo = new char[num];
        visited = new boolean[10];
        permutation = new int[num + 1];
        maxResult = new StringBuilder();
        minResult = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            boo[i] = st.nextToken().charAt(0);
        }

        permutation(0);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void permutation(int depth) {
        if (depth == num + 1) {
            if (isSatisfy()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < permutation.length; i++) {
                    sb.append(permutation[i]);
                }
                if (maxResult.length() == 0 || sb.toString().compareTo(maxResult.toString()) > 0) {
                    maxResult = new StringBuilder(sb);
                }
                if (minResult.length() == 0 || sb.toString().compareTo(minResult.toString()) < 0) {
                    minResult = new StringBuilder(sb);
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isSatisfy() {
        for (int i = 0; i < num; i++) {
            if (boo[i] == '>') {
                if (permutation[i] < permutation[i + 1]) {
                    return false;
                }
            } else {
                if (permutation[i] > permutation[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

