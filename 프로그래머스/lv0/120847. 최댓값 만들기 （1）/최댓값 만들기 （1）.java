class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int max=0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                answer = numbers[i]*numbers[j];
                max = Math.max(max,answer);
                answer = max;
            }
            
        }
                       
        return answer;
    }
}