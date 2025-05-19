import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N + 1][L + 1];
			int[] value = new int[N + 1];
			int[] calories = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				value[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][0] = 0;
			
			for(int i = 1; i <= N; i++) {
				for(int w = 0; w <= L; w++) {
					dp[i][w] = dp[i - 1][w];
					if(w >= calories[i]) {
						dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - calories[i]] + value[i]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + dp[N][L]);
		}
	}

}
