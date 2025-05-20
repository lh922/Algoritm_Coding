import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int count = 0;
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				int len = 0;
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						len++;
					} else {
						if(len == K) count++;
						len = 0;
					}
				}
				
				if(len == K) count++;
			}
			
			for(int i = 0; i < N; i++) {
				int len = 0;
				for(int j = 0; j < N; j++) {
					if(map[j][i] == 1) {
						len++;
					} else {
						if(len == K) count++;
						len = 0;
					}
				}
				
				if(len == K) count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}

}
