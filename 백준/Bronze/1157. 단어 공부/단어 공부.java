import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toUpperCase();
        char[] charArray = input.toCharArray();
        int[] count = new int[26];
        int intMax=0;
        for(int i=0; i<charArray.length; i++){
            count[charArray[i] - 'A'] += 1;
        }
        int max=0, subMax=0;
        for(int i=0; i<count.length; i++){
            if(intMax < count[i]){
                max = i;
                intMax = count[i];
            } 
            else if(intMax == count[i]) {
                subMax=intMax;
            }
        }
        char result = (char)(max + 65);
        if(intMax == subMax){
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}
