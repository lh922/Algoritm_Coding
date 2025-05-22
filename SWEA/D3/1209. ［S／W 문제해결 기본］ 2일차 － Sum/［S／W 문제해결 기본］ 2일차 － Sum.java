import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int[][] board = new int[100][100];
			br.readLine();
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxValue = Integer.MIN_VALUE;
			int sum = 0;
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += board[i][j];
				}
				maxValue = Math.max(maxValue, sum);
			}
			
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += board[j][i];
				}
				maxValue = Math.max(maxValue, sum);
			}
			
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += board[i][i];
			}
			maxValue = Math.max(maxValue, sum);
			
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += board[i][99 - i];
			}
			maxValue = Math.max(maxValue, sum);
			
			System.out.printf("#%d %d\n", tc, maxValue);
		}
	}

}
