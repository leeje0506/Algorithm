class Solution {
    
    public static int[][] computer;
    public static boolean [] visited;
    
    public int solution(int n, int[][] computers) {
        computer = computers;
        visited = new boolean[n];
        int answer = 0;
        
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int now){
        if(visited[now])
            return;
        
        visited[now] = true;
        
        for(int i=0; i<computer.length; i++){
            if(computer[now][i]==1){
                dfs(i);
            }
            
        }
    }
}