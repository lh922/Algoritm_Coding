import java.io.*;
import java.util.*;

public class Main {
  static int[][][] memorize = new int[21][21][21];
  public static int w(int a, int b, int c) {
    if(a <= 0 || b <= 0 || c <= 0) return 1;
    if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
    
    if(memorize[a][b][c] != 0) return memorize[a][b][c];
    
    if(a < b && b < c) {
      memorize[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    } else {
      memorize[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
    return memorize[a][b][c];
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int a, b, c;
    a = b = c = 0;
    
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      if(a == -1 && b == -1 && c == -1) break;
      else bw.write("w(" + a + ", " + b + ", " + c + ")" + " = " + w(a,b,c) + "\n");
    }
    bw.flush();
    br.close();
    bw.close();
  }
}