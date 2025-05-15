import java.io.*;
import java.util.*;

public class Solution {

	static int[][] square;
	static int[][] prefix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int maxValue = Integer.MIN_VALUE;
			
			square = new int[N + 1][N + 1];
			prefix = new int[N + 1][N + 1];
			
			for(int i = 1; i <= N; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
					prefix[i][j] = square[i][j] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
				}
			}
			
			for(int i = M; i <= N; i++) {
				for(int j = M; j <= N; j++) {
					int sum = prefix[i][j] - prefix[i - M][j] - prefix[i][j - M] + prefix[i - M][j - M];
					maxValue = Math.max(maxValue, sum);
				}
			}
			
			System.out.println("#" + tc + " " + maxValue);
		}
	}

}
