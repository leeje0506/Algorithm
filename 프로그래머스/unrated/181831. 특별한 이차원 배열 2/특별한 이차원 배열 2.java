class Solution {
    public int solution(int[][] arr) {
        int answer = 1;
        
        for(int r=0; r<arr.length; r++){           
            for(int c=0; c<arr[r].length; c++){
                if(arr[r][c] != arr[c][r]){
                    answer =0;
                }
            }
        }
        
        
        return answer;
    }
}