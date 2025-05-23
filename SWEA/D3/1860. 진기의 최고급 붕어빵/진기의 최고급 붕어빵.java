import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //사람의 수
			int M = Integer.parseInt(st.nextToken()); //소요 시간
			int K = Integer.parseInt(st.nextToken()); //만들어지는 붕어빵 개수
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int breadCnt = 0;
			boolean possible = true;
			for(int i = 0; i < N; i++) {
				int time = arr[i];
				breadCnt = (time / M) * K;
				
				if(breadCnt - i - 1 < 0) {
					possible = false;
					break;
				}
			}
			
			
			sb.append("#").append(tc).append(" ");
			if(possible) sb.append("Possible").append("\n");
			else sb.append("Impossible").append("\n");
			
		}
		
		System.out.println(sb);
	}

}
