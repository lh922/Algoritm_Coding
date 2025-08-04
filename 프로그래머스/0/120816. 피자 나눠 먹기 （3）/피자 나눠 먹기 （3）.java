class Solution {
    public int solution(int slice, int n) {
        int targetNum = 0;
        int answer = 0;
        
        while(targetNum < n) {
            targetNum += slice;
            answer++;
        }
        
        return answer;
    }
}