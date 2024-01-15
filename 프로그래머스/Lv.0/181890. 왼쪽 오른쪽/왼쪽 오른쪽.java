
import java.util.ArrayList;
import java.util.Arrays;

class Solution { 
    public String[] solution(String[] str_list) {
        ArrayList<String> list = new ArrayList<>();
        
        int idx = 0;
        
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")){
                idx = i;
                break;
            } else if(str_list[i].equals("r")){
                idx = i;
                break;
            }
        }
        
        if(str_list[idx].equals("l")){
            for(int i = 0; i < idx; i++){
                list.add(str_list[i]);
            }
        } else if(str_list[idx].equals("r")){
            for(int i = idx + 1; i < str_list.length; i++){
                list.add(str_list[i]);
            }
        }
        
        String[] answer = list.toArray(new String[0]);;
        
        return answer;
    }
}

