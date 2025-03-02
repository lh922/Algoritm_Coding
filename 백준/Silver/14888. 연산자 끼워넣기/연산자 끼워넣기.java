import java.io.*;
import java.util.*;

public class Main {
  static int[] arr; 
  static int[] operator = new int[4];
  static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, N;
  
  public static void dfs(int num, int index) {
    if(index == N) {
      min = Math.min(min, num);
      max = Math.max(max, num);
      return;
    }
    
    for(int i=0; i<4; i++) { //i는 연산자 종류
      if(operator[i] > 0) {
        operator[i]--; //보유 연산자 소모
        int newValue = calculate(num, arr[index], i);
        dfs(newValue, index + 1);
        operator[i]++; //백트레킹 초기화
      }
    }
  }
  
  public static int calculate(int a, int b, int op) {
    switch (op) {
      case 0 : return a + b;
      case 1 : return a - b;
      case 2 : return a * b;
      case 3 : return a / b;
    }
    return 0;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }
    
    dfs(arr[0], 1);
    
    System.out.println(max);
    System.out.println(min);
  }
}