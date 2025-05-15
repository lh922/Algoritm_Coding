import java.io.*;
import java.util.*;

public class Solution {

	static Set<String>[] visited;
	static char[] numbers;
	static int maxCount;
	static int maxValue;
	
	static void dfs(char[] number, int count) {
		if(maxCount == count) {
			maxValue = Math.max(maxValue, Integer.parseInt(new String(number)));
			return;
		}
		
		String currentNumber = new String(number);
		if(visited[count].contains(currentNumber)) return;
		visited[count].add(currentNumber);
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				char[] currentState = number.clone();
				char temp = currentState[i];
				currentState[i] = currentState[j];
				currentState[j] = temp;
				dfs(currentState, count + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			String[] line = br.readLine().split(" ");
			numbers = line[0].toCharArray();
			maxCount = Integer.parseInt(line[1]);
			maxValue = Integer.MIN_VALUE;
			visited = new HashSet[maxCount + 1];
			for(int i = 0; i <= maxCount; i++) {
				visited[i] = new HashSet<>();
			}
			
			dfs(numbers, 0);
			
			System.out.println("#" + tc + " " + maxValue);
		}
	}

}
