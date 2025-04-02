import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[][] items = new int[N][2];
    int[] dp = new int[K+1];
    
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      items[i][0] = weight;
      items[i][1] = value;
    }
    
    for(int i=0; i<N; i++) {
      int weight = items[i][0];
      int value = items[i][1];
      
      for(int w = K; w>=weight; w--) {
        dp[w] = Math.max(dp[w], dp[w-weight] + value);
      }
    }
    
    System.out.println(dp[K]);
  }
}