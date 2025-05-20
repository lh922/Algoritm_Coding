import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] scores = new int[N];
			int maxScore = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				maxScore += scores[i];
			}
			boolean[] dp = new boolean[maxScore + 1];

			dp[0] = true;
			
			for(int score : scores) {
				for(int i = maxScore; i >= 0; i--) {
					if(dp[i]) {
						dp[i + score] = true;
					}
				}
			}
			
			int count = 0;
			for(int i = 0; i <= maxScore; i++) if(dp[i]) count++;
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

}
