import java.util.*;
import java.io.*;

public class Solution {

	static List<List<Integer>> graph;
	static boolean[] visited;
	static int maxDepth;
	
	static void dfs(int vertex, int depth) {
		maxDepth = Math.max(maxDepth, depth);
		
		for(int next : graph.get(vertex)) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth + 1);
				visited[next] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>(N);
			for(int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken()) - 1;
				int u = Integer.parseInt(st.nextToken()) - 1;
				
				graph.get(v).add(u);
				graph.get(u).add(v);
			}

			maxDepth = 0;
			
			for(int i = 0; i < N; i++) {
				visited = new boolean[N];
				visited[i] = true;
				dfs(i, 1);
			}
			
			System.out.printf("#%d %d\n", tc, maxDepth);
		}
	}

}
