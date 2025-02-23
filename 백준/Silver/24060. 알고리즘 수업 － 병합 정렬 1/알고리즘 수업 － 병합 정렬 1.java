import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int[] numbers = new int[A];
    MergeSort merge = new MergeSort(K, A);
    st = new StringTokenizer(br.readLine());
    
    for(int i=0; i<A; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    
    merge.mergeSort(numbers, 0, numbers.length - 1);
    merge.printResult();
  }
}

class MergeSort {
  private int targetCount;
  private int currentCount = 0;
  private int result = - 1;
  private int[] tmp;
  
  public MergeSort(int targetCount, int arraySize) {
    this.targetCount = targetCount;
    tmp = new int[arraySize];
  }
  
  public void mergeSort(int[] nums, int start, int end) {
    if(start < end) {
      int mid = (start+end) / 2;
      mergeSort(nums, start, mid);
      mergeSort(nums, mid+1, end);
      merge(nums, start, mid, end);
    }
  }
  
  public void merge(int nums[], int start, int mid, int end) {
    int left = start;
    int right = mid + 1;
    int index = start;
    
    while(left <= mid && right <= end) {
      if(nums[left] <= nums[right]) {
        tmp[index++] = nums[left++];
      } else {
        tmp[index++] = nums[right++];
      }
    }
    
    // 앞부분이 남은 경우
    while(left <= mid) {
      tmp[index++] = nums[left++];
    }
    // 뒷부분이 남은 경우
    while(right <= end) {
      tmp[index++] = nums[right++];
    }
    
    left = start;
    index = start;
    while(left <= end) {
      nums[left++] = tmp[index++];
      currentCount++;
      if(targetCount == currentCount) {
        result = nums[left-1];
      }
    }
  }
  
  public void printResult() {
    System.out.println(result);
  }
}