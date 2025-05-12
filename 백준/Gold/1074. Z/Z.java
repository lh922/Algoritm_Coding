import java.util.Scanner;

public class Main {
    static int count = 0;
    static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int size = (int) Math.pow(2, n);
        solve(0, 0, size);
    }

    static void solve(int x, int y, int size) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int half = size / 2;

        // 1사분면
        if (r < x + half && c < y + half) {
            solve(x, y, half);
        }
        // 2사분면
        else if (r < x + half && c >= y + half) {
            count += half * half;
            solve(x, y + half, half);
        }
        // 3사분면
        else if (r >= x + half && c < y + half) {
            count += 2 * half * half;
            solve(x + half, y, half);
        }
        // 4사분면
        else {
            count += 3 * half * half;
            solve(x + half, y + half, half);
        }
    }
}
