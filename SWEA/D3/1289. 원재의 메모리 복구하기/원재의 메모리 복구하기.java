import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			int current = 0;
			int count = 0;
			
			for(int i = 0; i < line.length(); i++) {
				int bit = line.charAt(i) - '0';
				
				if(current != bit) {
					count++;
					current = bit;
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}

}
