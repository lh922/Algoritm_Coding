import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tCase = Integer.parseInt(br.readLine());
    
    for(int T=0; T<tCase; T++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[N];
      int highestValue = 0;
      long totalValue = 0;
      
      for(int i=0; i<N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int j=N-1; j>=0; j--) {
        if(highestValue < arr[j]) highestValue = arr[j];
        else if(arr[j] < highestValue) {
          totalValue += highestValue - arr[j];
        }
      }
      
      System.out.println(totalValue);
    }
  }
}