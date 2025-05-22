import java.util.*;
import java.io.*;

public class Solution {

	static int targetLength;
	static int count;
	static char[][] board = new char[8][8];
	
	static boolean isPalindromeRow (int row, int start) {
		for(int i = 0; i < targetLength / 2; i++) {
			if(board[row][start + i] != board[row][start + targetLength - 1 - i])
			return false;
		}
		return true;
	}
	
	static boolean isPalindromeCol (int col, int start) {
		for(int i = 0; i < targetLength / 2; i++) {
			if(board[start + i][col] != board[start + targetLength - 1 - i][col])
			return false;
		}
		return true;
	}	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			targetLength = Integer.parseInt(br.readLine());
			count = 0;
			
			for(int i = 0; i < 8; i++) {
				String line = br.readLine();
				for(int j = 0; j < 8; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			for(int i = 0; i < 8; i++) {
				for(int j = 0; j <= 8 - targetLength ; j++) {
					if(isPalindromeRow(i, j)) count++;
				}
			}
			
			for (int j = 0; j < 8; j++) {
			    for (int i = 0; i <= 8 - targetLength; i++) {
			        if (isPalindromeCol(j, i)) count++;
			    }
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}

}
