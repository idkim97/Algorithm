package algorithm;

import java.io.*;
import java.util.*;

public class 백준2580_스도쿠 {

    private static int[][] map = new int[9][9];
    private static int cnt=0;
    private static ArrayList<Pair> list= new ArrayList<Pair>();
    private static boolean flag;

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


        sudoku(0);

    }

    public static void sudoku(int depth){
        if(depth==cnt){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            flag = true;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            map[list.get(depth).x][list.get(depth).y] = i;
            if(check(list.get(depth))){
                sudoku(depth+1);
            }
            if(flag) return;

        }
        map[list.get(depth).x][list.get(depth).y] = 0;
    }

    public static boolean check(Pair p){
        int x_num = p.x/3;
        int y_num = p.y/3;


        for(int i=0;i<9;i++){
            if(p.x!=i && map[p.x][p.y]==map[i][p.y]) return false;
            if(p.y!=i && map[p.x][p.y]==map[p.x][i]) return false;
        }

        for(int i=x_num*3; i<x_num*3+3;i++){
            for(int j=y_num*3; j<y_num*3+3; j++){
                if(map[i][j]==map[p.x][p.y]){
                    if(p.x!=i && p.y!=j )
                        return false;
                }
            }
        }

        return true;
    }
}
