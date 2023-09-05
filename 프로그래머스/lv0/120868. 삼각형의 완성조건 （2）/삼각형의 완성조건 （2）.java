class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int cnt=0;
        
        //[0]이 가장 긴 경우
        if(sides[0]>=sides[1]){
            for(int i=1; i<=sides[0]; i++){
                if(sides[0]<sides[1]+i){
                    cnt++;
                }
            }
            //나머지 한 변이 가장 긴 경우
            for(int j=sides[0]+1; j<sides[0]+sides[1]; j++){
                cnt++;
            }
        }
        //[1]이 가장 긴 경우
        else if(sides[1]>=sides[0]){
            for(int i=1; i<=sides[1]; i++){
                if(sides[1]<sides[0]+i){
                    cnt++;
                }
            }
            //나머지 한 변이 가장 긴 경우
            for(int j=sides[1]+1; j<sides[0]+sides[1]; j++){
                cnt++;
            }
        }
        
        
        
        answer = cnt;
        return answer;
    }
}