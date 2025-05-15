import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			int[] numbersCount = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				numbersCount[score]++;
			}
			
			int maxCount = 0;
			int answer = 0;
			for(int i = 0; i <= 100; i++) {
				if(numbersCount[i] >= maxCount) {
					maxCount = numbersCount[i];
					answer = i;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
