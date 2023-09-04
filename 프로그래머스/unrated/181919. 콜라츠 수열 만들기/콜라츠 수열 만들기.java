import java.util.*;

class Solution {
    public int[] solution(int n) {
          
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n>1){
            list.add(n);
            if(n%2==0){
                n = n/2;
            }
            else if(n%2==1){
                n = (3*n)+1;                
            }
        }
        list.add(1);
        
        int[] answer = new int[list.size()];
        int idx = 0;
        //for-each문
        for (int num: list) {
            answer[idx++] = num;
        }
        return answer;
    }
}