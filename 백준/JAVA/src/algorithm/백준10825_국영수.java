package algorithm;

import java.io.*;
import java.util.*;

public class 백준10825_국영수 {

    private static ArrayList<Pair> list = new ArrayList<>();

    public static class Pair implements Comparable<Pair>{
        String name;
        int kor;
        int eng;
        int math;

        Pair(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public int compareTo(Pair p){
            if(this.kor == p.kor){
                if(this.eng == p.eng){
                    if(this.math == p.math){
                        return this.name.compareTo(p.name);
                    }
                    return p.math - this.math;
                }
                return this.eng-p.eng;
            }
            return p.kor-this.kor;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for(int i=0;i<n;i++) {
            String[] s = br.readLine().split(" ");
            list.add(new Pair(s[0], Integer.parseInt(s[1]),
                    Integer.parseInt(s[2]), Integer.parseInt(s[3])));
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).name);
        }
    }

}
