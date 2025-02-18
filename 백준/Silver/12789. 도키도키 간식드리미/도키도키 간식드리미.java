import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    Queue<Integer> line = new LinkedList<>();
    Stack<Integer> tmpLine = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int target = 1;
    
    for(int i=0; i<N; i++) {
      line.add(Integer.parseInt(st.nextToken()));
    }
    
    while(!line.isEmpty()) {
      int val = line.poll();
      
      if(target == val){
        target++;
      } else {
        tmpLine.push(val);
      }
      
      while(!tmpLine.isEmpty() && tmpLine.peek() == target) {
        tmpLine.pop();
        target++;
      }
    }
    
    while(!tmpLine.isEmpty()) {
      if(target != tmpLine.pop()){
        System.out.println("Sad");
        return;
      }
      target++;
    }
    System.out.println("Nice");
    
  }
}