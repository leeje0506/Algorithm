class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int denom = denom1 * denom2;
        int numer = (numer1*denom2)+(numer2*denom1);
        
        //기약분수 만들기
        for(int i=numer-1; i>1; i--){
            if(numer%i==0 && denom%i==0){
                
                numer/=i;
                denom/=i;
            }  
        }
        
    
     
    int [] answer = {numer, denom};
    return answer;
    }
}