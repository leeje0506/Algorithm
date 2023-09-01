class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        
        for(int n=0; n<queries.length; n++){
            int s = queries[n][0];
            int e = queries[n][1];
            int k = queries[n][2];
        
            
            for(int i=s; i<=e; i++){
                if(i%k==0){
                    arr[i]=arr[i]+1;
                }  
            }
            
            answer = arr;
        }
        
        return answer;
    }
}