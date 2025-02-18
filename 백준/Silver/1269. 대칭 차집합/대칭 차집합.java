import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        Set<Integer> B = new HashSet<>();
        
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
          A[i] = Integer.parseInt(stA.nextToken());
        }
        
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
          B.add(Integer.parseInt(stB.nextToken()));
        }
        
        int size = A.length + B.size();
        for(int i=0; i<A.length; i++){
          if(B.contains(A[i])){
            size -= 2;
          }
        }
        
        bw.write(String.valueOf(size));
        bw.flush();
        bw.close();
        br.close();
    }
}
