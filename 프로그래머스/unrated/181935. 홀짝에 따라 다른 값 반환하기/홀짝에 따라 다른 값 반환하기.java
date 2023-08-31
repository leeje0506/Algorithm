class Solution {
    public int solution(int n) {
        int answer = 0;
        int sumOdd = 0;
        int sumEven =0;
        
        for(int i=1; i<=n; i++){
            if(n%2==1){
                if(i%2==1){
                    sumOdd += i;
                    answer = sumOdd;
                }
                
            }
            
            else{
                if(i%2==0){
                    sumEven +=(i*i);
                    answer = sumEven;
                }
                
            }
            
             
        }
        return answer;  
    }
}