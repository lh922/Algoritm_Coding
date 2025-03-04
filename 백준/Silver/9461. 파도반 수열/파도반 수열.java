import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine());
    long[] DP = new long[101];
  
    DP[1] = 1;
    DP[2] = 1;
    DP[3] = 1;
    
    for(int N=4; N<=100; N++) {
      DP[N] = DP[N-2] + DP[N-3];
    }
    
    for(int i=0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());
      System.out.println(DP[N]);
    }
  }
}