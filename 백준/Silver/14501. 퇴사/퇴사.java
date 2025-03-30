import java.io.*;
import java.util.*;

public class Main {
  static int N, maxProfit = 0;
  static int[] T, P;
  
  public static void bruteForce(int day, int profit) {
    if (day > N) {
      maxProfit = Math.max(maxProfit, profit);
      return;
    }
    
    if (day + T[day] <= N + 1) {
      bruteForce(day + T[day], profit + P[day]);
    }
    
    bruteForce(day + 1, profit);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    T = new int[N + 1]; 
    P = new int[N + 1];
    
    for (int i = 1; i <= N; i++) { 
      StringTokenizer st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    
    bruteForce(1, 0);
    System.out.println(maxProfit);
  }
}
