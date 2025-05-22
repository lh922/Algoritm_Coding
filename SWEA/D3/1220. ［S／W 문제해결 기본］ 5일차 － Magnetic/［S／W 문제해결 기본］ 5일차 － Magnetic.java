import java.util.*;
import java.io.*;

public class Solution {

	static int[][] board = new int[100][100];
	static int count;
	
	static void checkDeadlock(int col) {
		boolean hasRed = false;
		
		for(int i = 0; i < 100; i++) {
			if(board[i][col] == 1) {
				hasRed = true;
			} else if(board[i][col] == 2) {
				if(hasRed) {
					count++;
					hasRed = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			count = 0;
			br.readLine();
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 100; i++) {
				checkDeadlock(i);
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	
	}

}
