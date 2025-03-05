import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int[][] cost = new int[N][3];
    int[][] dp = new int[N][3];
    
    
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      cost[i][0] = Integer.parseInt(st.nextToken()); //R cost
      cost[i][1] = Integer.parseInt(st.nextToken()); //G cost
      cost[i][2] = Integer.parseInt(st.nextToken()); //B cost  
    }
    
    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];
    
    for(int i=1; i<N; i++) {
      dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0]; //select R
      dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1]; //select G
      dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2]; //select B
    }
    
    System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
  }
}