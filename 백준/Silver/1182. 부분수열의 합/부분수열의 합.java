import java.util.*;
import java.io.*;

public class Main {
  static int[] arr;
  static int N, S, cnt = 0;
    
  public static void dfs(int idx, int sum) {
    if(idx == N) {
      if(S == sum) {
        cnt++;
      }
      return;
    }
    
    dfs(idx+1, sum + arr[idx]); //현재 원소를 택하는 경우
    dfs(idx+1, sum); //현재 원소를 택하지 않는 경우
  }
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = new int[N];
    
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    dfs(0, 0);
    
    if(S == 0) cnt--;
    
    System.out.println(cnt);
  }
}