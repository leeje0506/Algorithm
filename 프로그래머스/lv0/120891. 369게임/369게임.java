class Solution {
    public int solution(int order) {
        int answer = 0;
        int three=0;
        int six=0;
        int nine=0;
        
        String [] str = Integer.toString(order).split("");
        
        for(int i=0; i<str.length; i++){
            if(Integer.parseInt(str[i])==3){
                three++;
            }
            if(Integer.parseInt(str[i])==6){
                six++;
            }
            if(Integer.parseInt(str[i])==9){
                nine++;
            }
        }
        answer = three + six + nine;
        
        return answer;
    }
}