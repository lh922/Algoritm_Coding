import java.util.*;
import java.io.*;

public class Main {
	static int[][] square = new int[100][100];
	
	public static int getArea() {
		int area = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(square[i][j] == 1) {
					area++;
				}
			}
		}
		
		return area;
	}
	
	public static void paintSquare(int width, int length) {
		for(int i=width; i<width+10; i++) {
			for(int j=length; j<length+10; j++) {
				if(square[i][j] != 1) {
					square[i][j] = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] width = new int[N][N];
		int[][] length = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			width[i][i] = Integer.parseInt(st.nextToken());
			length[i][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			paintSquare(width[i][i], length[i][i]);
		}
		
		System.out.println(getArea());
	}

}