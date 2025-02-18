import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int K = Integer.parseInt(br.readLine());
    
    Stack<Integer> box = new Stack<>();
    
    for(int i=0; i<K; i++){
      int input = Integer.parseInt(br.readLine());
      if(input == 0){
        box.pop();
      } else {
        box.push(input);
      }
    }
    
    int size = box.size();
    int sum = 0;
    for(int i=0; i<size; i++){
      sum += box.pop();
    }
    bw.write(sum + "\n");
    
    bw.flush();
    br.close();
    bw.close();
  }
}

