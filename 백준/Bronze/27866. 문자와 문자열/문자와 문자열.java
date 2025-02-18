import java.util.Scanner;

class Main {
    public static void main(String[] args) {
            int location;
            String string, S[];
            Scanner sc = new Scanner(System.in);
            
            string = sc.nextLine();
            location = sc.nextInt()-1;
            S = string.split("");
            
            System.out.println(S[location]);
            
    }
}