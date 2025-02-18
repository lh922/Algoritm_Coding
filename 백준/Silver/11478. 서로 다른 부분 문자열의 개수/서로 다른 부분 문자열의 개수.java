import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
      Scanner sc = new Scanner(System.in);
      Set<String> result = new HashSet<>();
        
      String input = sc.nextLine();
      for(int i=0; i<input.length(); i++){
        for(int j=i+1; j<input.length()+1; j++){
          result.add(input.substring(i, j));
        }
      }
      
      System.out.println(result.size());
  }
}
