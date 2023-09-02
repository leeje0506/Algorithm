class Solution {
    //상 우 하 좌
    public static int [] dr = {-1,0,1,0};
    public static int [] dc = {0,1,0,-1};
    
    public int[][] solution(int n) {
        int[][] answer = new int [n][n];
        
        int r=0;
        int c=0;
        int d =0;
        int cnt =1;
        answer[r][c]=cnt++;
        
        while(cnt<=n*n){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr<0||nr>=n||nc<0||nc>=n||answer[nr][nc]>0){
                d=(d+1)%4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            r=nr;
            c=nc;
            answer[r][c] = cnt++;
        }//값 채우기
        
        
         return answer; 
    }
}