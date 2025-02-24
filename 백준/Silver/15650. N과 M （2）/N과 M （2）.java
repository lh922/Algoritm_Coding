import java.util.Scanner;
import java.io.*;

public class Main {
  static int[] arr;
  static boolean[] visit;
  static StringBuilder sb = new StringBuilder();
  
  private static void dfs(int N, int M, int depth, int start) {
    if(depth == M) {
      for(int a : arr) {
        sb.append(a + " ");
      }
      sb.append("\n");
      return;
    }
    
    for(int i=start; i<=N; i++) {
      if(!visit[i]) {
        visit[i] = true;
        arr[depth] = i;
        dfs(N, M, depth+1, i+1);
        visit[i] = false;
      }
    }
    return;
  }
  
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    arr = new int[M]; visit = new boolean[N+1];
    
    dfs(N, M, 0, 1);
    System.out.println(sb);
  }
}