import java.util.*;
class Solution {
    public String solution(String rny_string) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        
        String[] rny = rny_string.split("");
        
        for(int i=0; i<rny.length; i++){
            list.add(rny[i]);
            if(rny[i].equals("m")){
                list.remove("m");
                list.add("r");
                list.add("n");                    
            }
            
        }
        
        String[] str = list.toArray(new String[0]);
        
        for(int i=0; i<str.length; i++){
             answer += str[i];
        }
       
     
        return answer;
    }
}