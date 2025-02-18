import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++){
          nums[i] = Integer.parseInt(st.nextToken());
          if( (numberMap.get(nums[i]) != null) && (numberMap.get(nums[i]) >= 1) ){
            numberMap.put(nums[i], numberMap.get(nums[i])+1);
          } else{
            numberMap.put(nums[i], 1);
          }
        }
        
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        
        for(int i=0; i<M; i++){
          int num = Integer.parseInt(st1.nextToken());
          if( (numberMap.get(num) != null) ){
            bw.write(numberMap.get(num) + " ");            
          } else {
            bw.write(0 + " ");
          }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
