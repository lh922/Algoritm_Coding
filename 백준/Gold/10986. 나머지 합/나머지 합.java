import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] prefixSum = new long[N + 1];
		long[] prefixMod = new long[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < prefixSum.length; i++) {
			long num = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + num;
		}
		
		long count = 0;
		for(int i = 0; i <= N; i++) {
			int mod = (int) (prefixSum[i] % M);
			prefixMod[mod]++;
		}
		
		for(int i = 0; i < M; i++) {
			count += prefixMod[i] * (prefixMod[i] - 1) / 2; 
		}
		
		System.out.println(count);
	}

}
