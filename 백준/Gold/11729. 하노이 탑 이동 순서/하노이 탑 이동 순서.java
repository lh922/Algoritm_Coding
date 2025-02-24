import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      hanoi(N, 1, 2, 3);
      System.out.println((int)Math.pow(2, N) - 1);
      System.out.println(sb.toString());
    }
    
    public static void hanoi(int N, int start, int tmp, int end) {
      if(N == 1) {
        sb.append(start).append(" ").append(end).append("\n");
        return;
      }
      
      hanoi(N-1, start, end, tmp); //N-1개의 원판을 서브기둥으로 이동
      sb.append(start).append(" ").append(end).append("\n"); //가장 큰 원판을 목적기둥으로 이동
      hanoi(N-1, tmp, start, end); //서브 기둥에 있던 원판을 목적기둥으로 이동
    }
}
