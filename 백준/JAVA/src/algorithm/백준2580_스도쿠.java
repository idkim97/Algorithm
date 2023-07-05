package algorithm;

import java.io.*;
import java.util.*;

public class 백준2580_스도쿠 {

    private static int[][] map = new int[9][9];
    private static int cnt=0;
    private static ArrayList<Pair> list= new ArrayList<Pair>();

    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) {
                    list.add(new Pair(i,j));
                    cnt++; // 0의 개수 세기
                }
            }
        }


        dfs(0);

    }

    public static void dfs(int depth){
        if(depth==cnt){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            map[list.get(depth).x][list.get(depth).y] = i;
            check()

        }
    }

    public static boolean check(){

    }
}
