import java.util.*;
import java.io.*;

public class Solution {

	static char[][] board = new char[100][100];
	
	static boolean isPalindromeRow(int start, int end, int row) {
		while(start < end) {
			if(board[row][start++] != board[row][end--]) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean isPalindromeCol(int start, int end, int col) {
		while(start < end) {
			if(board[start++][col] != board[end--][col]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < 100; i++) {
				String line = br.readLine();
				for(int j = 0; j < 100; j++) {
					board[i][j] = line.charAt(j);
				}
			}
			
			int maxLength = 1;
			for(int length = 100; length >= 1; length--) {
				boolean found = false;
				
				for(int i = 0 ; i < 100; i++) {
					for(int j = 0; j <= 100 - length; j++) {
						if(isPalindromeCol(j, j + length - 1, i) || isPalindromeRow(j, j + length - 1, i)) {
							found = true;
							break;
						}
					}
					
					if(found) break;
					
				}
				
				if(found) {
					maxLength = length;
					break;
				}
				
			}
			
			System.out.printf("#%d %d\n", tcNum, maxLength);
		}
	}

}
