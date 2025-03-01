import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[N];
    int[] prefixSum = new int[N + 1];
    
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      prefixSum[i+1] = prefixSum[i] + arr[i];
    }
    
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int left = Integer.parseInt(st.nextToken());
      int right = Integer.parseInt(st.nextToken());
      
      sb.append(prefixSum[right] - prefixSum[left - 1]).append("\n");
    }
    
    System.out.println(sb);
  }
}