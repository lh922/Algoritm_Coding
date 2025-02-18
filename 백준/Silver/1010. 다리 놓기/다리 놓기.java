import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine());
    
    for(int i=0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[][] cache = new int[M+1][N+1];
      
      bw.write(binoCoef(M, N, cache) + "\n");
    }
    
    bw.flush();
    bw.close();
    br.close();
  }
  
  //binomial coeficient
  public static int binoCoef(int M, int N, int[][] cache) {

    
    if(M==N || N==0) {
      return cache[M][N] = 1;
    } else if(cache[M][N] != 0) {
      return cache[M][N];
    } else {
      return cache[M][N] = binoCoef(M-1, N, cache) + binoCoef(M-1, N-1, cache);
    }
      
  }
}