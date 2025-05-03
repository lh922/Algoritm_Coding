import java.io.*;
import java.util.*;

public class Main {

	static List<List<Integer>> network = new ArrayList<>();
	static boolean[] visited;
	
	public static void spreadVirus(int start) {
		for(int next : network.get(start)) {
			if(!visited[next]) {
				visited[next] = true;
				spreadVirus(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int M = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수
		
		visited = new boolean[N + 1];

		for(int i = 0; i <= N; i++) { //리스트 초기화
			network.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startVertex = Integer.parseInt(st.nextToken());
			int endVertex = Integer.parseInt(st.nextToken());
			
			network.get(startVertex).add(endVertex);
			network.get(endVertex).add(startVertex);
		}
		
		visited[1] = true; //1번 컴퓨터에서 감염 시작
		spreadVirus(1);
		
		int count = 0;
		for(int i = 2; i <= N; i++) {
			if(visited[i]) count++;
		}
		
		System.out.println(count);
	}

}
