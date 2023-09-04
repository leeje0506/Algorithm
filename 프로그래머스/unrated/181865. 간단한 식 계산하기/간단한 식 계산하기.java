class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String [] str = binomial.split(" ");
        
        if(str[1].contains("+")){
            answer = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
        }
        else if(str[1].contains("-")){
            answer = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
        }
        else if(str[1].contains("*")){
            answer = Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
        }
        return answer;
    }
}