package DP;

import java.io.*;
import java.util.*;

public class ���α׷��ӽ�_��� {

	public static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws IOException{
		
		int[][] puddles = {{2,2}};
		int[][] puddles = {{3,2}, {2,4}};
		int[][] puddles = {{2,1}, {1, 2}};
		int[][] puddles = {{2,1}};
		
		int res = solution(4,3,puddles);
		
		System.out.println(res);
	}
	
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        
        // ������ �־��ֱ�
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
     
        
        map[0][0]=1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==-1){
                    map[i][j]=0;
                    continue;
                }
                if(i!=0){
                    map[i][j] += map[i-1][j] % 1000000007;
                }
                
                if(j!=0){
                    map[i][j] += map[i][j-1] % 1000000007;
                }
                
                
            }
        }
        return map[n-1][m-1]%1000000007;
    }
}








