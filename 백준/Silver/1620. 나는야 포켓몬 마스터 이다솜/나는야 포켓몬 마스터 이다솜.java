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
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        HashMap<Integer, String> numberToName = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String input = br.readLine();
            nameToNumber.put(input, i+1);
            numberToName.put(i+1, input);
        }

        for(int i=0; i<M; i++){
            String input = br.readLine();
            try{
                num = Integer.parseInt(input);
                bw.write(numberToName.get(num) + "\n");
            } catch (Exception e) {
                bw.write(nameToNumber.get(input) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
