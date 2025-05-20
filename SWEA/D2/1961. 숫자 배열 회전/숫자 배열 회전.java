import java.util.*;
import java.io.*;

public class Solution {

    static String[][] rotate90(String[][] board, int N) {
        String[][] rotated = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[i][j] = board[N - 1 - j][i];
            }
        }
        return rotated;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[][] board = new String[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = st.nextToken();
                }
            }

            String[][] rot90 = rotate90(board, N);
            String[][] rot180 = rotate90(rot90, N);
            String[][] rot270 = rotate90(rot180, N);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append("\n");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) sb.append(rot90[i][j]);
                sb.append(" ");
                for (int j = 0; j < N; j++) sb.append(rot180[i][j]);
                sb.append(" ");
                for (int j = 0; j < N; j++) sb.append(rot270[i][j]);
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }
}
