import java.util.*;
import java.io.*;



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;
            int distSq = dx * dx + dy * dy;

            int rSum = r1 + r2;
            int rDiff = Math.abs(r1 - r2);

            if (distSq == 0 && r1 == r2) {
                sb.append(-1).append("\n"); // 같은 원 (무한 교점)
            } else if (distSq == rSum * rSum || distSq == rDiff * rDiff) {
                sb.append(1).append("\n"); // 외접 or 내접
            } else if (rDiff * rDiff < distSq && distSq < rSum * rSum) {
                sb.append(2).append("\n"); // 교점 2개
            } else {
                sb.append(0).append("\n"); // 교점 없음
            }
        }

        System.out.println(sb);
	}

}
