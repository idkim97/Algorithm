package algorithm;

import java.io.*;
import java.util.*;

public class 백준1987_알파벳 {

    private static int r, c;
    private static char[][] map;
    private static int[][] cnt;
    private static boolean[] alpha = new boolean[26];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int res = 0;

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

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        cnt = new int[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }


        Pair p = new Pair(0,0);
        dfs(p,0);

        System.out.println(res);

    }

    public static void dfs(Pair p, int cnt){

        int x = p.x;
        int y = p.y;

        if(alpha[map[x][y]-'A']){
            res = Math.max(res,cnt);
            return;
        }

        alpha[map[x][y]-'A'] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<r && ny>=0 && ny<c){
                dfs(new Pair(nx,ny),cnt+1);
            }
        }
        alpha[map[x][y]-'A'] = false;

    }


}
