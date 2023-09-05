import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        my_string = my_string.toLowerCase();
        
        String [] str = my_string.split("");
        
        Arrays.sort(str);
        
        for(int i =0; i<str.length; i++){
            answer+=str[i];
        }
        return answer;
    }
}