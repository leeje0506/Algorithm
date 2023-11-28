class Solution {
    public int solution(int[] numbers){
        
        //음수 고려해야하는 문제임! 다시 풀어보기~
        int max = Integer.MIN_VALUE;
        int answer =0;
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                 max = Math.max(numbers[i]*numbers[j], max);
            }
        }
        
        answer = max;
        
        return answer;
    }
}