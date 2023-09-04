import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        
        String [] str = myString.replace("x", " ").trim().split("\\s+");
        
        Arrays.sort(str);
        
        answer = str;
        
        return answer;
    }
}