class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        //아스키 코드에서 영어의 대문자는 65~90
        //소문자는 97~122 
        //영어의 대문자와 소문자 간의 간격은 32
        
        for (char c: my_string.toCharArray()) {
            if (c >= 97 && c <= 122) {
                answer += (char)(c - 32);
            } else if (c >= 65 && c <= 90) {
                answer += (char)(c + 32);
            }
        }
        return answer;
    }
}