import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> lines = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lines.add(new int[] {a, b});
		}
		lines.sort((a,b) -> a[0] - b[0]);
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int validLines = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(lines.get(i)[1] > lines.get(j)[1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			validLines = Math.max(validLines, dp[i]);
		}
		
		System.out.println(N-validLines);
	}

}