import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) { // 종료 조건
                break;
            }
            bw.write(Check(input) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static String Check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return "no"; // 스택이 비어 있으면 유효하지 않음
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return "no"; // 괄호 짝이 맞지 않음
                }
            }
        }
        
        return stack.isEmpty() ? "yes" : "no"; // 스택이 비어 있어야 유효
    }
}
