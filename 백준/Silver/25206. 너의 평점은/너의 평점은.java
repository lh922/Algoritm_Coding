import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Map<String, Float> scoreMap = new HashMap<>();
        scoreMap.put("A+", 4.5f);
        scoreMap.put("A0", 4.0f);
        scoreMap.put("B+", 3.5f);
        scoreMap.put("B0", 3.0f);
        scoreMap.put("C+", 2.5f);
        scoreMap.put("C0", 2.0f);
        scoreMap.put("D+", 1.5f);
        scoreMap.put("D0", 1.0f);
        scoreMap.put("F", 0.0f);
        
        float sumCredit= 0.0f;
        float totalScore = 0.0f;

        
        for(int i=0; i<20; i++){
            String line = sc.nextLine();
            String[] input = line.split(" ");
            String grade = input[2];
            float credit = Float.parseFloat(input[1]);
            
            if(!grade.equals("P")){
                totalScore += scoreMap.get(grade) * credit;
                sumCredit += credit;
            }
        }
        
        System.out.println(totalScore/sumCredit);
    }
}
