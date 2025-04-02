import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCaseCount = Integer.parseInt(br.readLine());
    
    for (int T = 0; T < testCaseCount; T++) {
      int numDays = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] stockPrices = new int[numDays];
      int maxStockPrice = 0;
      long maxProfit = 0;
      
      for (int i = 0; i < numDays; i++) {
        stockPrices[i] = Integer.parseInt(st.nextToken());
      }
      
      for (int j = numDays - 1; j >= 0; j--) {
        if (maxStockPrice < stockPrices[j]) {
          maxStockPrice = stockPrices[j]; 
        } else {
          maxProfit += maxStockPrice - stockPrices[j];
        }
      }
      
      System.out.println(maxProfit);
    }
  }
}
