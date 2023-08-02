package algorithm;

import java.io.*;
import java.util.*;

public class 백준2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();


        for(int num : list){
            sb.append(num);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
