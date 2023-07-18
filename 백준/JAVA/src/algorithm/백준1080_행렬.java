package algorithm;

import java.io.*;
import java.util.*;

public class 백준1080_행렬 {

    private static int[][] map;
    private static int[][] target;
    private static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        target = new int[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                target[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                if(map[i][j]!=target[i][j]) swap(i,j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(target[i][j]!=map[i][j]){
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(res);
    }

    public static void swap(int x, int y){
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(map[i][j]==1) map[i][j]=0;
                else map[i][j] = 1;
            }
        }
        res++;
    }
}
