import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    for(int T=0; T<10; T++) {
      int N = Integer.parseInt(br.readLine());
      int[] buildings = new int[N];
      int count = 0;
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
        buildings[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int i=2; i<N-2; i++) {
        int maxHeight = 0;
        for(int j=i-2; j<=i+2; j++) {
          if(i==j) continue;
          maxHeight = Math.max(maxHeight, buildings[j]);
        }
        
        if(buildings[i] > maxHeight) {
          count += buildings[i] - maxHeight;
        }
      }
      
      System.out.println("#" + (T+1) + " " + count);
    }
  }
}