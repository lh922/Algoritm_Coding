import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine());
    HashSet<String> set = new HashSet<>();
    int result = 0;

    while(N --> 0) {
      set.add(br.readLine());
      if(set.contains("ENTER")) {
        result += set.size() - 1;
        set.clear();
      }
    }
    
    result += set.size();  
    bw.write(Integer.toString(result));
    bw.flush();
    bw.close();
    br.close();
  }
}