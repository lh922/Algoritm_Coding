import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for(int i=0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[N];
      int highestValue = 0;
      long totalValue = 0;
      
      for(int j=0; j<N; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }
      
      for(int k=N-1; k>=0; k--) {
        if(highestValue < arr[k]) highestValue = arr[k];
        else if(highestValue > arr[k]) {
          totalValue += highestValue - arr[k];
        }
      }
      
      System.out.println("#" + (i+1) + " " + totalValue);
    }
  }
}