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
      
      for(int i=0; i<N; i++){
        int val = 1+i;
        queue.push(val);
      }
      
      while(!(queue.size() == 1)){
        queue.pop();
        int val = queue.pop();
        queue.push(val);
      }
      
      System.out.println(queue.front());
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
