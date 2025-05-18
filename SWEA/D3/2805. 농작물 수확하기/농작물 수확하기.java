import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray(); 
				for(int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0';
				}
			}
			
			for(int i = 0; i < N; i++) {
				int start = Math.abs(N / 2 - i);
				int end = N - start;
				for(int j = start; j < end; j++) {
					sum += map[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
		

	}

}
