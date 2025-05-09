import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] board = new boolean[N + 1][M + 1]; 
		int[][] wPrefix = new int[N + 1][M + 1]; //체스판이 W로 시작할 때 고쳐야 할 블럭의 수
		int[][] bPrefix = new int[N + 1][M + 1]; //B로 시작할 때 고쳐야 할 블럭의 수
		
		for(int i = 1; i <= N; i++) {
			String input = br.readLine();
			for(int j = 1; j <= M; j++) {
				board[i][j] = (input.charAt(j - 1) == 'B') ? true : false; //true: B, false: W
				
				bPrefix[i][j] = bPrefix[i][j - 1] + bPrefix[i - 1][j] - bPrefix[i - 1][j - 1];
				wPrefix[i][j] = wPrefix[i][j - 1] + wPrefix[i - 1][j] - wPrefix[i - 1][j - 1];
				
				if((i + j) % 2 == 0) {
					if(board[i][j]) wPrefix[i][j]++;
					else bPrefix[i][j]++;
				} else {
					if(board[i][j]) bPrefix[i][j]++;
					else wPrefix[i][j]++;
				}
				
			}
			
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = K; i <= N; i++) {
			for(int j = K; j <= M; j++) {
				int bBoard = bPrefix[i][j] - bPrefix[i - K][j] - bPrefix[i][j - K] + bPrefix[i - K][j - K];
				int wBoard = wPrefix[i][j] - wPrefix[i - K][j] - wPrefix[i][j - K] + wPrefix[i - K][j - K];
				
				result = Math.min(result, Math.min(bBoard, wBoard));
			}
		}
		
		System.out.println(result);
	}

}
