import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    
    int T = sc.nextInt();
    
    for(int i=0; i<T; i++){
      System.out.println(Check(sc.next()));
    }
  }
  
  public static String Check(String s){
  Stack<Character> stack = new Stack<>();
  for(char c : s.toCharArray()){
    if(c == '('){
      stack.push(c);
    } else if(stack.empty()){
      return "NO";
    } else {
      stack.pop();
    }
  }
  
  if(stack.empty()){
    return "YES";
  } else {
    return "NO";
  }
}
}