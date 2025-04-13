import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int q = Integer.parseInt(br.readLine());
		
		int prefix[][] = new int[input.length() + 1][26];
		
		
		for (int i = 1; i <= input.length(); i++) {
            char ch = input.charAt(i - 1);

            for (int j = 0; j < 26; j++) {
                prefix[i][j] = prefix[i - 1][j];
            }
            prefix[i][ch - 'a']++;
        }
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alphabet = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int count = prefix[r + 1][alphabet - 'a'] - prefix[l][alphabet - 'a'];
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}

}
