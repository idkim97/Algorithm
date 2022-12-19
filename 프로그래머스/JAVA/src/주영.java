import java.util.*;
import java.io.*;


public class ¡÷øµ {


   public static int T, N, M, K;
   public static int[][] map;
   public static int[][] tmpMap;
   public static final int[] dx = {0, 0, -1, 1};
   public static final int[] dy = {-1, 1, 0, 0};
   private static final int UP = 0;
   private static final int DOWN = 1;
   private static final int RIGHT = 2;
   private static final int LEFT = 3;
   private static final int DIR_NUM = 4;
//   public enum DIR
//   {
//      UP,
//      DOWN,
//      LEFT,
//      RIGHT,
//      DIR_NUM;
//
//      public static final int SIZE = java.lang.Integer.SIZE;
//
//      public int getValue()
//      {
//         return this.ordinal();
//      }
//
//      public static DIR forValue(int value)
//      {
//         return values()[value];
//      }
//   }



   public static ArrayList<Integer> order = new ArrayList<Integer>();
   public static int answer;
   
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      T = Integer.parseInt(br.readLine());


      for(int i=0; i < T; i++) {
    	 answer=0;
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
         map = new int[N+1][M+1];

         
         for(int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int k = 0; k < M; k++) {
               map[j][k] = Integer.parseInt(st.nextToken()); 
            }
         }
         permutationR(0,DIR_NUM,K);
         System.out.println("#"+(i+1)+" " + answer);
      }
   }
   public static void printMap(int[][] m) {
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < M; j++) {
            System.out.printf("%d ", m[i][j]);
         }
         System.out.print("\n");
      }
      System.out.print("\n");
   }
   
   public static void move(int d) {
      switch(d) {
      case UP:
      {
         for (int x = 0; x < M; x++) {
            for(int y = N - 1; y > 0; y--) {
               if(tmpMap[y][x] > 0) {
                  int ny = y + dy[0];
                  tmpMap[ny][x] += tmpMap[y][x];
                  tmpMap[y][x] = 0;
                  break;
               }
            }
         }
         break;
      }
      case DOWN:
      {
         for (int x = 0; x < M; x++)
         {
            for (int y = 0; y < N - 1; y++)
            {
               if (tmpMap[y][x] > 0)
               {
                  int ny = y + dy[1];
                  tmpMap[ny][x] += tmpMap[y][x];
                  tmpMap[y][x] = 0;
                  break;
               }
            }
         }
         break;
      }
      case LEFT:
      {
         for (int y = 0; y < N; y++)
         {
            for (int x = M - 1; x > 0; x--)
            {
               if (tmpMap[y][x] > 0)
               {
                  int nx = x + dx[2];
                  tmpMap[y][nx] += tmpMap[y][x];
                  tmpMap[y][x] = 0;
                  break;
               }
            }
         }
         break;
      }
      case RIGHT:
      {
         for (int y = 0; y < N; y++)
         {
            for (int x = 0; x < M - 1; x++)
            {
               if (tmpMap[y][x] > 0)
               {
                  int nx = x + dx[3];
                  tmpMap[y][nx] += tmpMap[y][x];
                  tmpMap[y][x] = 0;
                  break;
               }
            }
         }
         break;
      }
      }
   }

   public static int wind() {
      int result = 0;
      
      tmpMap = new int[N][M];
      //System.arraycopy(tmpMap, 0, map, 0, map.length);
      for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
      
      
      for(int i = 0; i < order.size(); i++) {
         move(order.get(i));
      }
      for(int y = 0; y < N; y++) {
         for(int x = 0; x < M; x++) {
            if(result < tmpMap[y][x]) {
               result = tmpMap[y][x];
            }
         }
      }
      return result;
   }
   
   public static void permutationR(int depth, int N, int r) {
      if (depth == r) {
         int result = wind();
         if (answer < result) {
            answer = result;
         }
         return;
      }
      for(int i = 0; i < N; i++) {
         order.add(i);
         permutationR(depth +1, N, r);
         order.remove(order.size()-1);
      }
   }

}