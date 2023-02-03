package DFSBFS;

import java.util.*;
import java.io.*;


public class temp
{
    private static int[][] map = new int[25][25];
    private static boolean[][] visited;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int[] arr = new int[25*25];
    private static int arrNum=0;
    private static int n;



    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];



        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = temp.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    arrNum++;
                    dfs(i,j);
                }
            }
        }

        Arrays.sort(arr);

        System.out.println(arrNum);

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                System.out.println(arr[i]);
            }
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        arr[arrNum]++;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}