package algorithm;

import java.io.*;
import java.util.*;
public class 백준10814_나이순정렬 {

    private static ArrayList<Pair> list = new ArrayList<>();

    public static class Pair implements Comparable<Pair>{
        int age;
        String name;

        Pair(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Pair p){
            return this.age-p.age;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Pair(age,name));
        }

        Collections.sort(list);

        for(int i=0;i<n;i++){
            System.out.println(list.get(i).age + " " + list.get(i).name);
        }

    }
}
