import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sum = 0, result = 5000/3; //max value
        boolean found = false;

        for(int i=0; i<=5000/5; i++){
            for(int j=0; j<5000/3; j++){
                sum = 5*i + 3*j;
                if(sum > N){continue;}
                if(sum == N && i+j < result){
                    found = true;
                    result = i+j;
                }
            }
        }

        if(!found){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}