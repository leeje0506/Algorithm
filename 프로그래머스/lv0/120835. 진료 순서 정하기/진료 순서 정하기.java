import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] arr = new int[emergency.length];
        for(int i = 0; i < emergency.length; i++){
            arr[i] = emergency[i];
        }
        
        Arrays.sort(arr);
        
        int idx=1;
        for(int i = 0; i < emergency.length; i++){
            for(int j=0; j<emergency.length; j++){
                if(emergency[i] == arr[j]){
                     answer[i]=emergency.length - j;  
                }
            }
        }
        return answer;
    }
}
