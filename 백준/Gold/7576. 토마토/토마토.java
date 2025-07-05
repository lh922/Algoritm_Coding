import java.util.*;
import java.io.*;

public class Main {

	static Queue<int[]> queue = new LinkedList<>();
	static int N, M;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] board, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dist = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					queue.add(new int[]{i, j});
				}
			}
		}

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0], y = now[1];

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(board[nx][ny] == 0) {
						board[nx][ny] = 1;
						dist[nx][ny] = dist[x][y] + 1;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}

		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				answer = Math.max(answer, dist[i][j]);
			}
		}
		System.out.println(answer);
	}
}
