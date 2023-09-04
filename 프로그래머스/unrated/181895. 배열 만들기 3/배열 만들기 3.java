import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int sr =0;
        int sc=0;
        
        for(int r=0; r<intervals.length; r++){            
            sr = intervals[r][0];
            sc = intervals[r][1];
            
            for(int i=sr; i<=sc; i++){
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            answer[index++] = list.get(i);
        }
        
        
        
        return answer;
    }
}