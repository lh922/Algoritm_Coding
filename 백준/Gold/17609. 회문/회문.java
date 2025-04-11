import java.util.*;
import java.io.*;

public class Main {
	 
	static StringBuilder sb = new StringBuilder();

	public static void check(String str) {
		int l = 0;
		int r = str.length() - 1;
		
		while(l < r) {
			if(str.charAt(l) == str.charAt(r)) {
				l++;
				r--;
			} else {
				if(isPalindrome(str, l + 1, r) || isPalindrome(str, l, r - 1)) {
					sb.append(1).append("\n"); 
					return ;
				} else {
					sb.append(2).append("\n");
					return ;
				}
			}
		}
		
		sb.append(0).append("\n");
	}
	
	public static boolean isPalindrome(String str, int l, int r) {
		while(l < r) {
			if(str.charAt(l) != str.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] inputs = new String[T];
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			inputs[i] = st.nextToken();
			check(inputs[i]);
		}
		
		System.out.println(sb);
	}

}