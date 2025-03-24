import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int[] A = new int[N];
    int[] front = new int[N];
    int[] rear = new int[N];
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      front[i] = 1;
      rear[i] = 1;
    }
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<i; j++) {
        if(A[i] > A[j]) {
          front[i] = Math.max(front[j] + 1, front[i]);
        }
      }
    }
    for(int i=N-1; i >= 0; i--) {
      for(int j=N-1; j>i; j--) {
        if(A[i] > A[j]) {
          rear[i] = Math.max(rear[j] + 1, rear[i]);
        }
      }
    }
    
    int maxBitonic = 0;
    for(int i=0; i<N; i++) {
      maxBitonic = Math.max(maxBitonic, front[i] + rear[i] - 1);
    }
    System.out.println(maxBitonic);
  }
}