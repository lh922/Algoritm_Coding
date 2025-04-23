import java.io.*;

public class Main {
	static int[][] square;
	static StringBuilder sb = new StringBuilder();
	
	public static boolean check(int x, int y, int size) {
		int initialNumber = square[x][y];
		
		for(int dx = x; dx < x + size; dx++) {
			for(int dy = y; dy < y + size; dy++) {
				if(square[dx][dy] != initialNumber) return false;
			}
		}
		
		return true;
	}
	
	public static void divide(int x, int y, int size) {
		
		if(check(x, y, size)) {
			sb.append(square[x][y]);
			return;
		}

		sb.append("(");
		
		int newSize = size / 2;
		int dx = x + newSize;
		int dy = y + newSize;
		
		divide(x, y, newSize);
		divide(x, dy, newSize);
		divide(dx, y, newSize);
		divide(dx, dy, newSize);
		sb.append(")");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		square = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				square[i][j] = line.charAt(j) - '0';
			}
		}
		
		divide(0, 0, N);
		System.out.println(sb);
	}
}
