import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int maxSafeArea = Integer.MIN_VALUE;
  static int[][] map;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
  public static void makeWall(int count) {
    if(count == 3) {
      int[][] cloneMap = copyMap();
      spreadVirus(cloneMap);
      return ;
    }
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map[i][j] == 0) {
          map[i][j] = 1;
          makeWall(count + 1);
          map[i][j] = 0;
        }
      }
    }
  }
  
  public static void spreadVirus(int[][] cloneMap) {
    Queue<int[]> virusCoordinate = new LinkedList<>();
    
    for(int i=0; i<N; i++) { //바이러스 좌표값 저장
      for(int j=0; j<M; j++) {
        if(cloneMap[i][j] == 2) {
          virusCoordinate.offer(new int[]{i, j});
        }
      }
    }
    
    while(!virusCoordinate.isEmpty()) {
      int[] now = virusCoordinate.poll();
      
      int x = now[0];
      int y = now[1];
      
      for(int d=0; d<4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        
        if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if(cloneMap[nx][ny] == 0) {
            cloneMap[nx][ny] = 2;
            virusCoordinate.offer(new int[]{nx, ny});
          }
        }
      }
    }
    
    countSafeArea(cloneMap);
  }
  
  public static void countSafeArea(int[][] cloneMap) {
    int count = 0;
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) { 
        if(cloneMap[i][j] == 0) count++;
      }
    }
    
    maxSafeArea = Math.max(maxSafeArea, count);
  }
  
  public static int[][] copyMap() {
    int[][] copyMap = new int[N][M];
    
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        copyMap[i][j] = map[i][j];
      }
    }
    
    return copyMap;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    
    for(int i=0; i<N; i++) { //map 생성
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    makeWall(0);
    System.out.println(maxSafeArea);
  }
}