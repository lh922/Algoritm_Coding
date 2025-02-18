import java.util.*;

class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    
    for(int i=1; i<=N; i++){
      queue.add(i);
    }
    
    while(!queue.isEmpty()){
      for(int i=0; i<K-1; i++){
        queue.add(queue.poll());
      }
      
      result.add(queue.poll());
    }
    
    System.out.println(result.toString().replace("[", "<").replace("]", ">"));
  }
}