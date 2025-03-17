import java.util.*;
import java.io.*;

public class Main {
  static  int[] dpOfZero = new int[41];
  static  int[] dpOfOne = new int[41];
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    dpOfZero[0] = 1;
    dpOfOne[0] = 0;
    dpOfZero[1] = 0;
    dpOfOne[1] = 1;
    
    for(int i=2; i<=40; i++) {
      dpOfZero[i] = dpOfZero[i-1] + dpOfZero[i-2];
      dpOfOne[i] = dpOfOne[i-1] + dpOfOne[i-2];
    }
    
    int T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++) {
      int num = Integer.parseInt(br.readLine());
      sb.append(dpOfZero[num]).append(" ").append(dpOfOne[num]).append("\n");
    }
    System.out.println(sb);
  }
}