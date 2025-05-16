import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] map = new int[100][100];
	static int result;
	

    static void findLoc(int x, int y) {
        while (y > 0) {
            // 좌측 먼저 확인
            if (x > 0 && map[y][x - 1] == 1) {
                while (x > 0 && map[y][x - 1] == 1) {
                    x--;
                }
            }
            // 우측 확인
            else if (x < 99 && map[y][x + 1] == 1) {
                while (x < 99 && map[y][x + 1] == 1) {
                    x++;
                }
            }
            // 위로 이동
            y--;
        }
        result = x;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int xLoc = 0;
			result = 0;
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) xLoc = j;
				}
			}
			
			findLoc(xLoc, 99);
            System.out.println("#" + tc + " " + result);
		}

	}

}
