import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] count = new int[26];
		
		for(char c : input.toCharArray()) {
			count[c - 'A']++;
		}
		
		int odd = 0;
		int oddIndex = -1;
		
		for(int i=0; i<26; i++) {
			if(count[i] % 2 != 0) {
				odd++;
				oddIndex = i;
			}
		}
		
		if(odd >= 2) {
			System.out.println("I'm Sorry Hansoo");
			return ;
		}
		
		StringBuilder half = new StringBuilder();
		for(int i=0; i<26; i++) {
			for(int j=0; j<count[i] / 2; j++) {
				half.append((char)(i + 'A'));
			}
		}
		
		StringBuilder result = new StringBuilder(half);
		if(odd == 1) {
			result.append((char)(oddIndex + 'A'));
		}
		result.append(half.reverse());
		
		System.out.println(result);
	}

}
