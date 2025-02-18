import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] num = new int[N];

        for(int i=0; i<num.length; i++){
            num[i] = sc.nextInt();
        }

        for(int i=0; i<num.length-1; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[i]<num[j]){
                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }

        System.out.println(num[k-1]);
    }
}