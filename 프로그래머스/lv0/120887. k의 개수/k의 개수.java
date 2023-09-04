import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        int idx=0;
        int [] nums = new int [j-i+1];
        
        for(int num=i; num<=j; num++){
            nums[idx++] = num;
        }
        
        String s = Arrays.toString(nums);
        String [] str = s.split("");
        
        for(int m=0; m<str.length; m++){
            if(str[m].equals(Integer.toString(k))){
                answer++;
            }
        }
        
        return answer;
    }
}