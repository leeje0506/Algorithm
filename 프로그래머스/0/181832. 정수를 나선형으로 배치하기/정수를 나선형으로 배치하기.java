class Solution {
public static int[] dr = {0, 1, 0, -1}; 
public static int[] dc = {1, 0, -1, 0};

    
    public int[][] solution(int n) {
        int[][] board = new int[n][n];
        int r = 0;
        int c = 0;
        int d = 0;
        int number = 1;
        
        while(number <= n*n){
            board[r][c] = number++;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] != 0) {
                d = (d+1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            
            r = nr;
            c = nc;
        }
        
        return board;
    }
}