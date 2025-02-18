import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      int A1, A2, B1, B2;
      int[] result = new int[2];
      
      A1 = sc.nextInt();
      A2 = sc.nextInt();
      B1 = sc.nextInt();
      B2 = sc.nextInt();

      int lcm = LCM(A2, B2);
      
      result[0] = A1*(lcm/A2) + B1*(lcm/B2);
      result[1] = lcm;
      
      if( GCD(result[0], result[1]) != 1 ){
        int temp = GCD(result[0], result[1]);
        result[0] /= temp;
        result[1] /= temp;
      }
      
      System.out.println(result[0] + " " + result[1]);
  }
  
  public static int GCD(int a, int b){
    if(b == 0) return a;
    return GCD(b, a%b);
  }
  
  public static int LCM(int a, int b){
    return a*b/GCD(a, b);
  }
  
}
