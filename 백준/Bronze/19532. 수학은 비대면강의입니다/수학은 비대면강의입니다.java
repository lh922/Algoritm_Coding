import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int c1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();

        // 해를 찾는 플래그
        boolean found = false;
        int x = 0, y = 0;

        // 브루트포스 탐색 범위 설정 (임의의 큰 범위로 설정)
        for (x = -999; x <= 999; x++) {
            for (y = -999; y <= 999; y++) {
                // 두 방정식을 만족하는 (x, y) 찾기
                if (a1 * x + b1 * y == c1 && a2 * x + b2 * y == c2) {
                    found = true;
                    System.out.printf("%d %d\n", x, y);
                    break;
                }
            }
            if (found) break; // 해를 찾으면 종료
        }
    }
}