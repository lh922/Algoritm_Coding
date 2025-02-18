import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int input;

    ArrayList<Integer> nums = new ArrayList<>();
    
    while((input = Integer.parseInt(br.readLine())) != 0){
      nums.add(input);
    }
    
    for(int i=0; i<nums.size(); i++){
      int cnt = 0;
      int n = nums.get(i);
      for(int j=n+1; j<=n*2; j++){
        if(isPrime(j)){
          cnt++;
        }
      }
      bw.write(cnt + "\n");
    }
    
    bw.flush();
    bw.close();
    br.close();
  }
  
  
  public static boolean isPrime(int num){
    if(num < 2) {
      return false;
    } else if (num == 2){
      return true;
    } 
    
    for(int i=2; i<=Math.sqrt(num); i++){
      if(num % i == 0){
        return false;
      }
    }
    
    return true;
  }
}