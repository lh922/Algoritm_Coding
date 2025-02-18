import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
        
    int N = Integer.parseInt(br.readLine()); // 큐와 스택의 개수
    String[] types = br.readLine().split(" "); // 자료구조 타입 (0 = 큐, 1 = 스택)
    String[] values = br.readLine().split(" "); // 초기 값
    
    Deque<Integer> queue = new LinkedList<>();
    for(int i=0; i<N; i++) {
      if(types[i].equals("0")) { //큐인 경우에만 저장
        queue.add(Integer.parseInt(values[i]));
      }
    }
    
    int M = Integer.parseInt(br.readLine());
    String[] insertValues = br.readLine().split(" ");
    
    for(int i=0; i<M; i++) {
      queue.addFirst(Integer.parseInt(insertValues[i])); //큐에 입력 수열 삽입
    }
    
    while(M --> 0) {
      sb.append(queue.pollLast()).append(" ");
    }
    System.out.println(sb);
  }
}