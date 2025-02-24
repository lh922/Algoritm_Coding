import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String input;
    while((input=br.readLine()) != null) {
      int N = Integer.parseInt(input);
      int lineLength = (int) Math.pow(3, N);
      char[] arr = new char[lineLength];
      
      for(int i=0; i<lineLength; i++) {
        arr[i] = '-';
      }
      
      cantonianSet(arr, 0, lineLength);
      bw.write(arr);
      bw.newLine();
    }
      bw.flush();
      br.close();
      bw.close();
    
  }
  
  public static void cantonianSet(char[] arr, int start, int lineLength) {
    if(lineLength < 3) return;
    
    int partSize = lineLength / 3;
    int oneThirdPoint = start + partSize;
    int twoThirdPoint = oneThirdPoint + partSize;
    
    for(int i=oneThirdPoint; i<twoThirdPoint; i++) {
      arr[i] = ' ';
    }
    
    cantonianSet(arr, start, partSize);
    cantonianSet(arr, twoThirdPoint, partSize);
  }
}