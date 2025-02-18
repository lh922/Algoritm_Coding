import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] divisiors = new int[N];
    
    for(int i=0; i<N; i++) {
      divisiors[i] = sc.nextInt();
    }
    
    Arrays.sort(divisiors);
    
    System.out.println(divisiors[0] * divisiors[N-1]);
  }
}