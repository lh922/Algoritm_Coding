import java.util.*;
import java.io.*;

public class Solution {
	
	static Set<String> visited;
	static String board[][];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static void dfs(int x, int y, String number) {
		number += board[x][y];
		if(number.length() == 7) {
			visited.add(number);
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
				continue;
			}
			dfs(nx, ny, number);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			board = new String[4][4];
			visited = new HashSet<String>();
			
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					board[i][j] = st.nextToken();
				}
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					String number = "";
					dfs(i, j, number);
				}
			}
			
			System.out.printf("#%d %d\n", tc, visited.size());
		}
	}

}
