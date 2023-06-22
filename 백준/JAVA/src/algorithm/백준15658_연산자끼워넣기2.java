package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준15658_연산자끼워넣기2 {

    private static int n;
    private static int[] arr;
    private static int[] ops = new int[4];
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            ops[i] = Integer.parseInt(st.nextToken());
        }


        dfs(arr[0],1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int total, int idx){
//        System.out.println(total);
        if(idx==n){
            max = Math.max(total,max);
//                System.out.println(max);
            min = Math.min(total,min);
//                System.out.println(min);
            return;
        }

        for(int i=0;i<4;i++){

            if(ops[i]==0) continue;

            switch(i){
                case 0:
                    ops[i]--;
                    dfs(total+arr[idx], idx+1);
                    break;

                case 1:
                    ops[i]--;
                    dfs(total-arr[idx], idx+1);
                    break;

                case 2:
                    ops[i]--;
                    dfs(total*arr[idx], idx+1);
                    break;

                case 3:
                    ops[i]--;
                    if(total<0){
                        total = Math.abs(total);
                        dfs(total/arr[idx]-(total/arr[idx])*2,idx+1);
                    }else dfs(total/arr[idx], idx+1);
                    break;
            }

            ops[i]++;
        }
    }
}
