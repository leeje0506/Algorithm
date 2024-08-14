class Solution {
    public int solution(int[] array, int n) {
        
        int answer = 0;
        
        //길이만큼 돌리고 n이 있다면 answer을 ++ 해주는 방법.
        //의문점 => 음. 이게 최적인가...
        for(int i=0; i<array.length; i++){
            if(array[i]==n){
                answer++;
            }
        }
        
        return answer;
        
    }
}