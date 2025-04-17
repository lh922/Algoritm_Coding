import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int line = 1;
        int sum = 0;

        while (sum + line < X) {
            sum += line;
            line++;
        }

        int position = X - sum;

        int numerator, denominator;
        if (line % 2 == 0) {
            // 짝수 라인: 아래로 감 (1/line, 2/(line-1), ..., line/1)
            numerator = position;
            denominator = line - position + 1;
        } else {
            // 홀수 라인: 위로 감 (line/1, (line-1)/2, ..., 1/line)
            numerator = line - position + 1;
            denominator = position;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
