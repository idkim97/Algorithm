package algorithm;

import java.io.*;
import java.util.*;

public class 백준16928_뱀과사다리게임 {
    private static int n;
    private static int m;

    private static int[] move;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        move = new int[30];

        for(int i=0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }

        bfs();
    }

    public static void bfs(){
        
    }


}
