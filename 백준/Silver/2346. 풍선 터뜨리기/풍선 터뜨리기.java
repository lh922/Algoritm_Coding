import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> deq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deq.offer(new Balloon(i, move));
        }

        List<Integer> result = new ArrayList<>();

        while (!deq.isEmpty()) {
            Balloon current = deq.poll();
            result.add(current.index);

            if (deq.isEmpty()) break;

            int move = current.value;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deq.addLast(deq.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deq.addFirst(deq.pollLast());
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + (i == result.size() - 1 ? "" : " "));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Balloon {
        int index;
        int value;

        public Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
