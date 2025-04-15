import java.util.*;
import java.io.*;

class Main {
  static List<List<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();
  
  public static void dfs(int vertex) {
    visited[vertex] = true;
    sb.append(vertex).append(" ");
    
    for(int next : graph.get(vertex)) {
      if(!visited[next]) {
        dfs(next);
      }
    }
  }
  
  public static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.offer(start);
    
    while(!queue.isEmpty()) {
      int vertex = queue.poll();
      sb.append(vertex).append(" ");
      
      for(int next : graph.get(vertex)) {
        if(!visited[next]) {
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    
    for(int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int startVertex = Integer.parseInt(st.nextToken());
      int endVertex = Integer.parseInt(st.nextToken());
      
      graph.get(startVertex).add(endVertex);
      graph.get(endVertex).add(startVertex);
    }
    
    for(int i = 1; i <= N; i++) {
      Collections.sort(graph.get(i));
    }
    
    visited = new boolean[N + 1];
    dfs(V);
    sb.append("\n");
    
    visited = new boolean[N + 1];
    bfs(V);
    System.out.println(sb);
  }
}