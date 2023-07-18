package algorithm;

import java.io.*;
import java.util.*;





public class 백준1931_회의실배정2 {

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

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(a,b));
        }

        Collections.sort(list,new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.y==p2.y) return p1.x-p2.x;
                else{
                    return p1.y - p2.y;
                }
            }
        });

        int prev = 0;

        for(int i=0;i<list.size();i++){
            if(prev <= list.get(i).x){
                prev = list.get(i).y;
                res++;
            }
        }

        System.out.println(res);
    }
}
