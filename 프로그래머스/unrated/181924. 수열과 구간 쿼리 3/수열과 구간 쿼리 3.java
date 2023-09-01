class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for(int cnt=0; cnt<queries.length; cnt++){
            int iIdx = queries[cnt][0];
            int jIdx = queries[cnt][1];
            
            int tmp = arr[iIdx];
            arr[iIdx] = arr[jIdx];
            arr[jIdx] =tmp;
        }
        
        answer = arr;
        return answer;
    }
}