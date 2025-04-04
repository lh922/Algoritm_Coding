import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] arr, result;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void dfs(int depth) {
    if (depth == M) { // M개를 선택했으면 출력
      for (int num : result) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) { // 방문하지 않은 숫자라면 선택
        visited[i] = true;
        result[depth] = arr[i];
        dfs(depth + 1);
        visited[i] = false; // 백트래킹
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    arr = new int[N];
    result = new int[M];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr); // 오름차순 정렬 (사전순 출력을 위해)
    
    dfs(0); // 백트래킹 시작
    System.out.println(sb);
  }
}
