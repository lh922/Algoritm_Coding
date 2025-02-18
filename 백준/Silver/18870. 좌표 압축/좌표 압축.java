import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] original = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            original[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> pointsMap = new HashSet<>();

        for(int i=0; i<original.length; i++){
            pointsMap.add(original[i]);
        }

        List<Integer> pointsList = new ArrayList<>(pointsMap);
        HashMap<Integer, Integer> result = new HashMap<>();
        Collections.sort(pointsList);

        for(int i=0; i<pointsMap.size(); i++){
            result.put(pointsList.get(i), i);
        }


        for(int i=0; i<original.length; i++){
            bw.write(result.get(original[i]) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}