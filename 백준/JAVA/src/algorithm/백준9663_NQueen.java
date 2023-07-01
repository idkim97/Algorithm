package algorithm;

import java.io.IOException;
import java.util.Scanner;

public class 백준9663_NQueen {

    private static int[] map;
    private static int n;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n];       // map[x]=y -> x행 y열에 퀸이 존재한다.

        NQueens(0);

        System.out.println(count);

    }

    public static void NQueens(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i=0;i<n;i++){
            map[depth] = i;
            if(check(depth)){
                NQueens(depth+1);
            }
        }
    }

    public static boolean check(int depth){

        for(int i=0;i<depth;i++){
            // 같은 열인지 확인
            if(map[depth] == map[i]) return false;
            // 대각선인지 확인
            else if(Math.abs(map[depth]-map[i])==Math.abs(depth-i)) return false;
        }




        return true;
    }
}
