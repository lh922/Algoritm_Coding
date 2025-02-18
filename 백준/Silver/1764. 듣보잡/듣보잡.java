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
        
        HashMap<String, Integer> unknownPeople = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i=0; i<N; i++){
          unknownPeople.put(br.readLine(), 0);
        }
        for(int i=0; i<M; i++){
          String input = br.readLine();
          if(unknownPeople.get(input) != null){
            result.add(input);
            cnt++;
          }
        }
        
        Collections.sort(result);
        System.out.println(cnt);
        for(String unknown : result){
          bw.write(unknown + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
