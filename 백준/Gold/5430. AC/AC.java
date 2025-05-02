import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			String commands = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			Deque<Integer> deque = new ArrayDeque<>(n);
			input = input.substring(1, input.length() - 1); //[1, 2, 3] -> 1, 2, 3
			if(!input.isEmpty()) {
				String[] elements = input.split(",");
				for(int i = 0; i < n; i++) {
					deque.add(Integer.parseInt(elements[i]));
				}
			}
			
			boolean isError = false;
			boolean isReversed = false;
			
			for(char c : commands.toCharArray()) {
				if(c == 'R') {
					isReversed = !isReversed;
				} else { // if c == 'D'
					
					if(deque.isEmpty()) {
						isError = true;
						break;
					} 
					
					if(isReversed) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}
			
			if(isError) {
				System.out.println("error");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				
				while(!deque.isEmpty()) {
					sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
					if(!deque.isEmpty()) sb.append(",");
				}
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
}
