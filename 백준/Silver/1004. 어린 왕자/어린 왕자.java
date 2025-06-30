import java.util.*;
import java.io.*;

public class Main {

	public static boolean isInside(int x, int y, int cx, int cy, int r) {
		int d = (x - cx) * (x - cx) + (y - cy) * (y - cy);
		int squaredRadius = r * r;
		
		return d < squaredRadius;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {			
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean startIn = isInside(x1, y1, cx, cy, r);
				boolean endIn = isInside(x2, y2, cx, cy, r);
				
				if(startIn != endIn) cnt++;
			}
			System.out.println(cnt);
		}
		
	}

}
