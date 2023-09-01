class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int n=0; n<queries.length; n++){
            int s = queries[n][0];
            int e = queries[n][1];
            int k = queries[n][2];
           
            int min = 1000001;
            
            for(int i=s; i<=e; i++){
                if(arr[i] > k){
                   min= Math.min(min,arr[i]);
                }    
            }
            if(1000001 == min){
                answer[n] = -1;
            } else {
                answer[n] = min;
            }
        
        }

        return answer;
    }
}