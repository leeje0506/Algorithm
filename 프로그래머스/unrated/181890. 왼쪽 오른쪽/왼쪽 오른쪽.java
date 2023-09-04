import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        
        int indexL = str_list.length;
        int indexR = str_list.length;
        
        ArrayList<String> list = new ArrayList<>();
        
       outer : for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l")){
                indexL =i;
                for(int j=0; j<indexL; j++){
                    list.add(str_list[j]);
                }
                break outer;
            }
            else if(str_list[i].equals("r")){
                indexR =i;
                for(int j=indexR+1; j<str_list.length; j++){
                    list.add(str_list[j]);
                }
                break outer;
            }
            
        }
        String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
}
