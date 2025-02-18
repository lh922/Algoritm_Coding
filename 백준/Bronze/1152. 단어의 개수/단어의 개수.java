import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input;
        input = sc.nextLine();
        
        input = input.trim();
        if(input.length() == 0){
            System.out.println(input.length());
        }else{
            String arrString[] = input.split(" ");
            System.out.println(arrString.length);
        }
    }
}