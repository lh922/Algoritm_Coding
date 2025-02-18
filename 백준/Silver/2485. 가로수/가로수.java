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

        int N = Integer.parseInt(br.readLine());
        int[] position = new int[N];
        int[] distance = new int[N-1];
        int treeNum = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            position[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            distance[i] = position[i+1] - position[i];
        }

        int gcd = distance[0];
        for(int i=1; i<distance.length; i++){
            gcd = GCD(gcd,distance[i]);
        }

        for(int dist : distance){
            treeNum += (dist/gcd) - 1;
        }

        bw.write(Integer.parseInt(treeNum + "") + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    public static int GCD (int a, int b){
        if(b==0) return a;
        return GCD(b, a%b);
    }
}