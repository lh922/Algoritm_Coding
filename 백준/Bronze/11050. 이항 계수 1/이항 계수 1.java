import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    System.out.println(bino_coef(N, K));
  }
  
  public static int facotirial(int num) {
    int result = 1;
    for(int i=2; i<num+1; i++) {
      result *= i;
    }
    return result;
  }
  
  public static int bino_coef(int N, int K) {
    return facotirial(N) / (facotirial(K) * facotirial(N-K));
  }
}