package algorithm;

import java.io.*;
import java.util.*;

public class 백준12886_돌그룹 {

    private static int a, b, c;
    private static boolean visited[][] = new boolean[1500][1500];
    private static ArrayList<Integer> list = new ArrayList<>();




    public static class Pair{
        int a;
        int b;
        int c;

        Pair(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bfs(a,b,c);




    }

    public static void bfs(int a, int b, int c){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(a,b,c));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.a;
            int y = p.b;
            int z = p.c;

            if(x==y && y==z) {
                System.out.println("1");
                return;
            }

            int nx=0,ny=0,nz=0;

            if(x!=y){
                if(x>y) {
                    nx = x-y;
                    ny = 2*y;
                }
                else{
                    nx = 2*x;
                    ny = y-x;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx,ny,z));
                }
            }

            if(y!=z){
                if(y>z){
                    ny = y-z;
                    nz = 2*z;
                }
                else{
                    ny = 2*y;
                    nz = z-y;
                }
                if(!visited[ny][nz]){
                    visited[ny][nz] = true;
                    q.offer(new Pair(x,ny,nz));
                }
            }

            if(z!=x){
                if(z>x){
                    nz = z-x;
                    nx = 2*x;
                }
                else{
                    nz = 2*z;
                    nx = x-z;
                }
                if(!visited[nz][nx]){
                    visited[nz][nx] = true;
                    q.offer(new Pair(nx,y,nz));
                }
            }
        }

        System.out.println("0");

    }






}
