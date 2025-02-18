import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
      LinkedListQueue queue = new LinkedListQueue();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int N = Integer.parseInt(br.readLine());
      int result;
      
      for(int i=0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String option = st.nextToken();
        
        switch(option){
          case "push":
            queue.push(Integer.parseInt(st.nextToken()));
            break;
          case "pop":
            result = queue.pop();
            bw.write(result + "\n");
            break;
          case "front":
            result = queue.front();
            bw.write(result + "\n");
            break;
          case "back":
            result = queue.back();
            bw.write(result + "\n");
            break;
          case "size":
            result = queue.size();
            bw.write(result + "\n");
            break;
          case "empty":
            result = queue.empty();
            bw.write(result + "\n");
            break;
          default:
            break;
        }
          
      }
      
      bw.flush();
      bw.close();
      br.close();
  }
}

class Node {
  int value;
  Node nextNode;
  
  public Node(int value) {
    this.value = value;
    this.nextNode = null;
  }
}

class LinkedListQueue {
  private Node front;
  private Node back;
  private int size;
  
  public LinkedListQueue() {
    front = back = null;
    size = 0;
  }
  
  public boolean isEmpty() {
    return front == null;
  }
  
  public void push(int value) {
    Node newNode = new Node(value);
    size++;
    if(isEmpty()){
        front = back = newNode;
    } else {
      back.nextNode = newNode;
      back = newNode;
    }
  }
  
  public int pop() {
    if(isEmpty()){
      return -1;
    } else {
      int value = front.value;
      front = front.nextNode;
      
      if(front == null){
      back = null;
    }
    
    size--;
    return value;
    }
  }
  
  public int size() {
    return size;
  }
  
  public int front() {
    return isEmpty() ? -1 : front.value;
  }
  
  public int back() {
    return isEmpty() ? -1 : back.value;
  }
  
  public int empty() {
    return isEmpty() ? 1 : 0;
  }
}
