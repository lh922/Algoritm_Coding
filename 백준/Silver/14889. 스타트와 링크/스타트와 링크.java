import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void dfs(int idx, int count) {
        if (count == N / 2) { // 팀이 완성된 경우
            calculateDifference();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    public static void calculateDifference() {
        int startTeam = 0, linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(minDiff);
    }
}