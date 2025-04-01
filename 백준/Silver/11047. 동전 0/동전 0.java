import java.io.*;
import java.util.*;

public class Main {
  static int N, K;
  static int[] coins;
  
  public static int coinChange() {
    int count = 0;
    
    for(int i = N-1; i>=0; i--) {
      count += K / coins[i];
      K %= coins[i];
    }
    return count;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    coins = new int[N];
    
    for(int i=0; i<N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }
    
    System.out.println(coinChange());
  }
}