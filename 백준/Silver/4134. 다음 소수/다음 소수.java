import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    Long[] nums = new Long[n];
    
    for(int i=0; i<n; i++){
      nums[i] = Long.parseLong(br.readLine());
    }
    
    
    for(int i=0; i<nums.length; i++){
      Long result = nextPrime(nums[i]);
      System.out.println(result);
    }
  }
  
  public static Long nextPrime(Long num){
    while(!(isPrime(num))){
      num++;
    }
    return num;
  }
  
  public static boolean isPrime(Long num){
    if(num < 2){
      return false;
    } else if(num == 2){
      return true;
    }
    Double sqrt = Math.sqrt(num);
    for(int i=2; i<=sqrt; i++){
      if(num % i == 0){
        return false;
      }
    }
    return true;
  }
}