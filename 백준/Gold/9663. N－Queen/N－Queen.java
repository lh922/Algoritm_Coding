import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int result;
  static boolean[] col, cross1, cross2; //cross1은 좌상향 cross2는 우상향
  
  public static void promising(int row) {
    if(row == N) {
      result++;
      return;
    }
    
    for(int c=0; c<N; c++) {
      if(!col[c] && !cross1[c-row + (N-1)] && !cross2[c+row]) {
        col[c] = cross1[c-row + (N-1)] = cross2[c+row] = true;
        promising(row+1);
        col[c] = cross1[c-row + (N-1)] = cross2[c+row] = false;
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    col = new boolean[N];
    cross1 = new boolean[N*2];
    cross2 = new boolean[N*2];
    
    promising(0);
    System.out.println(result);
  }
}