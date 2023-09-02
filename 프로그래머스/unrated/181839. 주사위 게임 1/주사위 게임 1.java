class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        //둘 다 홀수X (둘 다 짝수)
        if(a%2==0 && b%2==0){
            answer = Math.abs(a-b);            
        }
        // 둘 중 하나만 홀수
        else if(a%2==1 && b%2==0 || a%2==0 && b%2==1){
            answer = 2*(a+b);
        }
        // 둘 다 홀수
        else if(!(a%2==0 && b%2==0)){
            answer = (a*a)+(b*b);
        }
        
        return answer;
    }
}