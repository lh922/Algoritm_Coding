import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> nums = new ArrayList<>();
    Map<Integer, Integer> numCount = new HashMap<>();
    int N = Integer.parseInt(br.readLine());
    
    for(int i=0; i<N; i++) {
      int input = Integer.parseInt(br.readLine());
      nums.add(input);
      numCount.put(input, numCount.getOrDefault(input, 0) + 1);
    }
    Calculator cal = new Calculator(nums, numCount);
    System.out.println(cal.getMean());
    System.out.println(cal.getMedian());
    System.out.println(cal.getMode());
    System.out.println(cal.getRagne());
  }
}

class Calculator {
  private List<Integer> numbers;
  private Map<Integer, Integer> numberCount;
  
  public Calculator(List<Integer> numbers, Map<Integer, Integer> numberCount) {
    this.numbers = new ArrayList<>(numbers);
    this.numberCount = new HashMap<>(numberCount);
    Collections.sort(this.numbers);
  }
  
  public int getMean() {
    double sum = 0;
    for(int num : numbers) {
      sum += num;
    }
    return (int) Math.round(sum / numbers.size());
  }
  
  public int getMedian() {
    int size = numbers.size();
    return numbers.get(size/2);
  }
  
  public int getMode() {
    int maxFrequency = Collections.max(numberCount.values());
    List<Integer> modeCandidates = new ArrayList<>();
    
    for(Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
      if (entry.getValue() == maxFrequency) {
        modeCandidates.add(entry.getKey()); 
      }
    }
    
    Collections.sort(modeCandidates);
    
    return modeCandidates.size() > 1 ? modeCandidates.get(1) : modeCandidates.get(0);
  }
  
  public int getRagne() {
    return numbers.get(numbers.size() - 1) - numbers.get(0);
  }
}
