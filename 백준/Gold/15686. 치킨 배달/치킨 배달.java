import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static int minChickenCityDistance = Integer.MAX_VALUE;
  static List<int[]> houses = new ArrayList<>();
  static List<int[]> chickens = new ArrayList<>();
  
  public static void selectChickens(int start, List<int[]> selected) {
    if(selected.size() == M) { 
      minChickenCityDistance = Math.min(minChickenCityDistance, getDistance(selected));
      return;
    }
    
    for(int i = start; i<chickens.size(); i++) {
      selected.add(chickens.get(i));
      selectChickens(i + 1, selected);
      selected.remove(selected.size() - 1); // 마지막으로 추가된 치킨집의 좌표를 삭제하여 백트래킹
    }
  }
  
  //|r1-r2| + |c1-c2| 거리 공식
  public static int getDistance(List<int[]> selected) {
    int totalDistance = 0;
    
    for(int[] house : houses) {
      int minDist = Integer.MAX_VALUE;
      for(int[] chicken : selected) {
        int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
        minDist = Math.min(minDist, distance);
      }
      totalDistance += minDist;
    }
    
    return totalDistance;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        int value = Integer.parseInt(st.nextToken());
        if(value == 1) houses.add(new int[]{i, j});
        else if(value == 2) chickens.add(new int[]{i, j});
      }
    }
    
    selectChickens(0, new ArrayList<>());
    System.out.println(minChickenCityDistance);
  }
}