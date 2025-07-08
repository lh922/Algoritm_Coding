import java.util.*;
import java.io.*;

public class Main {
	
	static Queue<Integer[]> deque = new LinkedList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] board, dist;
	static boolean[][] visited;
	static int N, M;
	
	static void bfs() {
		while(!deque.isEmpty()) {
			Integer[] current = deque.poll();
			int x = current[0];
			int y = current[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] != 0) {
					visited[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
					deque.offer(new Integer[] {nx, ny});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		int startX = 0;
		int startY = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					startX = i;
					startY = j;
					deque.offer(new Integer[] {startX, startY});
					visited[startX][startY] = true;
					dist[startX][startY] = 0;
				} else if(board[i][j] == 0) {
					visited[i][j] = true;
					dist[i][j] = 0;
				} else {
					dist[i][j] = -1;
				}
			}
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
