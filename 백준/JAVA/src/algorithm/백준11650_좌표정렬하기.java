package algorithm;

import java.io.*;
import java.util.*;

public class 백준11650_좌표정렬하기 {

    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y =y;
        }

        @Override
        public int compareTo(Pair p){
            if(p.x==this.x) return this.y-p.y;
            return this.x-p.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list.add(new Pair(num1,num2));
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).x + " " + list.get(i).y);
        }
    }

}
