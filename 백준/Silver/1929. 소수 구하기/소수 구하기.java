import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M, N;
        int[] nums = new int[1000001];

        for (int i = 2; i < nums.length; i++) {
            nums[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 에라토스테네스의 체 구현
        for (int i = 2; i * i < nums.length; i++) { // i * i로 최적화
            if (nums[i] != 0) { 
                for (int j = i * i; j < nums.length; j += i) { // 배수 처리
                    nums[j] = 0;
                }
            }
        }

        // 결과 출력
        for (int i = M; i <= N; i++) {
            if (nums[i] != 0) {
                bw.write(nums[i] + "\n");
            }
        }

        bw.flush();
    }
}
