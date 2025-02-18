import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        
        int distanceToleft = x;
        int distanceToRight = w - x;
        int distanceToTop = y;
        int distanceToBottom = h - y;
        
        int minDistance = Math.min(Math.min(distanceToleft, distanceToRight), Math.min(distanceToTop, distanceToBottom));
        
        System.out.println(minDistance);
    }    
}
    