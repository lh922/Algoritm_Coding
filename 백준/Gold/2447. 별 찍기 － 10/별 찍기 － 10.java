import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //정사각형 길이
        char[][] arr = new char[N][N];

        // 배열을 '*'로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = '*';
            }
        }

        // 공백을 만드는 재귀 함수 호출
        getIt(arr, 0, 0, N);

        // 출력
        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void getIt(char[][] arr, int x, int y, int N) {
        if(N < 3) return;
        int partSize = N / 3;
        
        for(int i = x + partSize; i < x + 2 * partSize; i++) {
          for(int j = y + partSize; j < y + 2 * partSize; j++) {
            arr[i][j] = ' ';
          }
        }
        
        for(int dx = 0; dx<3; dx++) {
          for(int dy = 0; dy<3; dy++) {
            if(dx == 1 && dy == 1) continue;
            getIt(arr, x + dx * partSize, y + dy * partSize, partSize);
          }
        }
    }
}
