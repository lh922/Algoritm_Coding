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
    int T = Integer.parseInt(br.readLine());
    int[] nums = new int[1000001];

    for (int i = 2; i < nums.length; i++) {
      nums[i] = i;
    }
    
    for(int i=2; i*i<nums.length; i++){
      if(nums[i] != 0){
        for(int j=i*i; j<nums.length; j+=i){
          nums[j] = 0;
        }
      }
    }    
    
    for(int i=0; i<T; i++){
      int cnt = 0;
      int num = Integer.parseInt(br.readLine());
      for(int j=2; j<=num/2; j++){
        if( (nums[j] != 0) && (nums[num-j] != 0) ){
          cnt++;
        }
      }
      bw.write(cnt + "\n");
    }
    
    
    bw.flush();
    bw.close();
    br.close();
  }
}