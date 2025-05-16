import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[100];
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			int maxDump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
						
			while(maxDump-- > 0) {
				Arrays.sort(arr);
				arr[arr.length - 1]--;
				arr[0]++;
			}
			
			Arrays.sort(arr);
			int result = arr[arr.length - 1] - arr[0];
			sb.append("#" + tc + " " + result).append("\n");
		}
		
		System.out.println(sb);
	}

}
