import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String s = "";
        
        String [] str = myString.split("");
        
        for(int i=0; i<str.length; i++){
            if(str[i].equals("A")){
                str[i] = "B";
            }
            else{ 
                str[i] = "A";
            }
        }
        
        for(int i=0; i<str.length; i++){
            s += str[i];
        }
        
        if(s.contains(pat)){
            answer = 1;
        }
        return answer;
    }
}