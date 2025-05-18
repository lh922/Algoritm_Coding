import java.util.*;
import java.io.*;

public class Solution {

	static int[][] sdoku = new int[9][9];

	// 가로 검증
	static boolean checkWidth() {
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10]; // 1~9 체크용
			for (int j = 0; j < 9; j++) {
				int num = sdoku[i][j];
				if (check[num]) return false;
				check[num] = true;
			}
		}
		return true;
	}

	// 세로 검증
	static boolean checkLength() {
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				int num = sdoku[j][i];
				if (check[num]) return false;
				check[num] = true;
			}
		}
		return true;
	}

	// 3x3 정사각형 검증
	static boolean checkSquare() {
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				boolean[] check = new boolean[10];
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						int num = sdoku[i + r][j + c];
						if (check[num]) return false;
						check[num] = true;
					}
				}
			}
		}
		return true;
	}

	// 전체 스도쿠 검사
	static boolean checkSdoku() {
		return checkWidth() && checkLength() && checkSquare();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = checkSdoku() ? 1 : 0;
			System.out.println("#" + tc + " " + result);
		}
	}
}
