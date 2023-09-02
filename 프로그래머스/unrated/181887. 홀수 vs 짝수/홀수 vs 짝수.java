class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sumEven =0;
        int sumOdd = 0;
        
        for(int i=0; i<num_list.length; i++){
            if((i+1)%2==0){
                sumEven += num_list[i];
            }
            if((i+1)%2==1){
                sumOdd += num_list[i];
            }
        }
        
        if(sumEven>sumOdd){
            answer = sumEven;
        }else if(sumEven < sumOdd){
            answer = sumOdd;
        }else{
            answer = sumEven;
        }
        
        return answer;
    }
}