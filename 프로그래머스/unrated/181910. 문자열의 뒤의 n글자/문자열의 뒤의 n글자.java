class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        String [] str = my_string.split("");
        
        for(int i=str.length-n; i<str.length; i++){
            answer += str[i];
        }
        return answer;
    }
}