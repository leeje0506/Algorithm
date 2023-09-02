import java.util.*;
class Solution {
    public String solution(String rny_string) {
        String answer = "";
        //넣고 빼고 자유롭게 하기 위해 ArrayList 사용함
        ArrayList<String> list = new ArrayList<>();
        
        //입력되는 문자열을 문자열 배열으로 만든다.
        String[] rny = rny_string.split("");
        
        //문자열 배열 크기만큼 반복하면서 list에 값을 넣어준다
        //m이면 list에서 m을 삭제하고, r,n을 넣어준다
        for(int i=0; i<rny.length; i++){
            list.add(rny[i]);
            if(rny[i].equals("m")){
                list.remove("m");
                list.add("r");
                list.add("n");                    
            }
            
        }
        
        //ArrayList를 Array로 만들어준다.([0]으로 하면 arr크기에 맞춰 알아서 들어간다)
        String[] str = list.toArray(new String[0]);
        
        //str의 크기만큼 돌면서 answer에 추가해준다. (문자열)
        for(int i=0; i<str.length; i++){
             answer += str[i];
        }
       
     
        return answer;
    }
}
