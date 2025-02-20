import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    HashSet<String> set = new HashSet<>();
    set.add("ChongChong");

    while(N --> 0) {
      String[] input = br.readLine().split(" ");
      if(set.contains(input[0]) || set.contains(input[1])) {
        set.add(input[0]);
        set.add(input[1]);
      }
    }

    System.out.println(set.size());
    br.close();
  }
}