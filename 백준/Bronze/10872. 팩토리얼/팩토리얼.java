import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt() + 1;
    int result = 1;
    while(n --> 1) {
      result *= n;
    }
    System.out.println(result);
  }
}