import java.util.*;
import java.io.*;

public class Solution {
	static int N, result;
	static boolean[] queen;
	static boolean[] cross1, cross2;
	
	static void dfs(int row) {
		if(N == row) {
			result++;
			return;
		}
		
		for(int c = 0; c < N; c++) {
			if(!queen[c] && !cross1[row + c] && !cross2[row - c + N]) {
				queen[c] = cross1[row + c] = cross2[row - c + N] = true;
				dfs(row + 1);
				queen[c] = cross1[row + c] = cross2[row - c + N] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			queen = new boolean[N];
			cross1 = new boolean[N * 2];
			cross2 = new boolean[N * 2];
			
			dfs(0);
			System.out.println("#" + tc + " " + result);
		}
	}

}
