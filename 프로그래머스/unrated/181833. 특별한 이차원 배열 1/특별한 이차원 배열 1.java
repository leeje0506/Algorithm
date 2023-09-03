class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(r==c){
                    answer[r][c]=1;
                }else{
                    answer[r][c]=0;
                }
            }
        }
        return answer;
    }
}