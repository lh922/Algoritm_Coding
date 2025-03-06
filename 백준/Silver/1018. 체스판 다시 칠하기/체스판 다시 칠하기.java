import java.io.*;

public class Main {
    static char[][] board;
    static int N, M;

    public static int countRepaints(int x, int y, char firstColor) {
        int repaintCount = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i][y + j] != firstColor) {
                    repaintCount++;
                }
                // 다음 칸 색상 변경 (체스판 특성상 다음 색은 반대색이어야 함)
                firstColor = (firstColor == 'B') ? 'W' : 'B';
            }
            firstColor = (firstColor == 'B') ? 'W' : 'B'; // 줄이 바뀌면 다시 반대색부터 시작
        }

        return repaintCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaints = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int countB = countRepaints(i, j, 'B'); // 'B'로 시작하는 경우
                int countW = countRepaints(i, j, 'W'); // 'W'로 시작하는 경우
                minRepaints = Math.min(minRepaints, Math.min(countB, countW));
            }
        }

        System.out.println(minRepaints);
    }
}
