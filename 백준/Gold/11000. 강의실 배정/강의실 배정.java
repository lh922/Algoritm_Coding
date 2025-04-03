import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    int[][] lectures = new int[N][2];
    
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      lectures[i][0] = Integer.parseInt(st.nextToken()); //수업 시작 시간
      lectures[i][1] = Integer.parseInt(st.nextToken()); //수업 종료 시간
    }
    
    Arrays.sort(lectures, (a, b) -> { //수업 시작시간 기준으로 오름차순 정렬
      if(a[0] == b[0]) {
        return a[1] - b[1];
      }
      
      return a[0] - b[0];
    });
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(lectures[0][1]);
    
    for(int i=1; i<N; i++) {
      if(pq.peek() <= lectures[i][0]) pq.poll();
      pq.offer(lectures[i][1]);
    }
    
    System.out.println(pq.size());
  }
}