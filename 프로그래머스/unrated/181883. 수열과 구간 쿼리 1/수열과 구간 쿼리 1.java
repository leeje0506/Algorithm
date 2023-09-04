class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int s =0;
        int e =0;
        
        for(int r=0; r<queries.length; r++){
            s = queries[r][0];
            e = queries[r][1];
            
           
            for(int i=s; i<=e; i++){
                arr[i] = arr[i]+1;
            }   
        }
        answer = arr;
        return answer;
    }
}