class Solution {
    public String solution(int n) {
        String answer = "";
        
        String []str = (Integer.toString(n)).split("");
        
        for(int i=0; i<str.length; i++){
            answer += str[i];
        }
        
        return answer;
    }
}