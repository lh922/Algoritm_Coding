import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    
    StackArray stack = new StackArray(N);
    
    for(int i=0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int option = Integer.parseInt(st.nextToken());
      
      switch(option){
        case 1:
          stack.push(Integer.parseInt(st.nextToken()));
          break;
        case 2:
          bw.write(stack.pop() + "\n");
          break;
        case 3:
          bw.write(stack.size() + "\n");
          break;
        case 4:
          if(stack.isEmpty()) {
            bw.write(1 + "\n");
          } else {
            bw.write(0 + "\n");
          }
          break;
        case 5:
          bw.write(stack.peek() + "\n");
          break;
      }
    }
    
    bw.flush();
    bw.close();
    br.close();
  }
}

class StackArray{
  private int maxSize;
  private int top;
  private int[] stackArray;
  
  public StackArray(int size){
    maxSize = size;
    stackArray = new int[maxSize];
    top = -1;
  }
  
  public void push(int data) {
    if(top == maxSize -1){
      return;
    }
    stackArray[++top] = data;
  }
  
  public int pop() {
    if(isEmpty()){
      return -1;
    }
    return stackArray[top--];
  }
  
  public boolean isEmpty() {
    return top == -1;
  }
  
  public int size() {
    return top+1;
  }
  
  public int peek() {
    if(isEmpty()){
      return -1;
    }
    return stackArray[top];
  } 
}