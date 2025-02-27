import java.io.*;
import java.util.*;

public class Main {
  static int[] arr;
  
  public static int getIt(int N) {
    if(N <= 2) return arr[N];
    if(arr[N] != 0) return arr[N];
    
    arr[N] = (getIt(N-1) + getIt(N-2)) % 15746 ;
    return arr[N];
  }
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    arr = new int[N+1];
    arr[1] = 1;
    if(N >= 2) arr[2] = 2;

    getIt(N);
    
    System.out.println(arr[N]);
  }
}