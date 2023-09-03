import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int idx =0;  //answer 배열의 크기용
        int cnt =0;
        
        char[] c = my_string.toCharArray();
        
        for(int i=0; i<c.length; i++){
            if(!(c[i]>=97 && c[i]<=122)){
                cnt++;                
            }
        }
        
         int[] answer = new int [cnt];
        
        for(int i=0; i<c.length; i++){
            if(!(c[i]>=97 && c[i]<=122)){
                answer[idx++] = c[i]-'0';                
            }
        }
        
        Arrays.sort(answer);
        return answer;
    }
}