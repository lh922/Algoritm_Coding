import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;

public class Main{
    public static int[] recursion(String s, int l, int r){
      int[] result = new int[2];
      if(l >= r) {
        result[0] = 1;
        result[1] = l+1;
        return result;
      }
      else if(s.charAt(l) != s.charAt(r)) {
        result[0] = 0;
        result[1] = l+1;
        return result;
      }
      else return recursion(s, l+1, r-1);
    }
    public static int[] isPalindrome(String s){
      return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int T = Integer.parseInt(br.readLine());
      for(int i=0; i<T; i++) {
        String input = br.readLine();
        int[] result = isPalindrome(input);
        bw.write(result[0] + " " + result[1] + "\n");
      }
      bw.flush();
      bw.close();
      br.close();
    }
}