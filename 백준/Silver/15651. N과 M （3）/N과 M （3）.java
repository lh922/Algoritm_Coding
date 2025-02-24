import java.util.Scanner;
import java.io.*;

public class Main {
  static int[] arr;
  static StringBuilder sb = new StringBuilder();
  
  private static void dfs(int N, int M, int depth) {
    if(depth == M) {
      for(int a : arr) {
        sb.append(a + " ");
      }
      sb.append("\n");
      return;
    }
    
    for(int i=1; i<=N; i++) {
      arr[depth] = i;
      dfs(N, M, depth+1);
    }
    return;
  }
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    arr = new int[M];
    
    dfs(N, M, 0);
    System.out.println(sb);
  }
}