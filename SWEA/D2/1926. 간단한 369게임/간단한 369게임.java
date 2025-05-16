import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			String temp = Integer.toString(i);
			char[] number = temp.toCharArray();
			
			int count = 0;
			for(char c : number) {
				if(c == '3' || c == '6' || c == '9') count++;
			}
			
			if(count != 0) {
				while(count --> 0) sb.append('-');
			} else {
				sb.append(number);
			}
			
			sb.append(" ");
		}
		
		System.out.println(sb);
	}

}
