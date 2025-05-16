import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            int[] heightCount = new int[101]; // 높이 범위는 1 ~ 100

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                int h = Integer.parseInt(st.nextToken());
                heightCount[h]++;
            }

            int min = 1;
            int max = 100;

            while (dump-- > 0) {
                while (heightCount[max] == 0) max--;
                while (heightCount[min] == 0) min++;
                
                if (max - min <= 1) break; // 더 이상 평탄화 불가

                heightCount[max]--;
                heightCount[max - 1]++;
                heightCount[min]--;
                heightCount[min + 1]++;
            }

            while (heightCount[max] == 0) max--;
            while (heightCount[min] == 0) min++;

            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }

        System.out.print(sb);
    }
}
