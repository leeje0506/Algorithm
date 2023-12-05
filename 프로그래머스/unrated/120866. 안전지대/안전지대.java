class Solution {
    
    public static int [] dr ={0,1,-1,0,-1,1,1,-1};
    public static int [] dc = {1,0,0,-1,-1,1,-1,1};
    
    public int solution(int[][] board) {
        int answer = 0;
                
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(board[r][c]==1){
                    for(int d=0; d<8; d++){
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    if(nr>=0&&nr<board.length&&nc>=0&&nc<board[0].length&&board[nr][nc]!=1){
                        board[nr][nc]=2; 
                    }
                    }
                }
            }
        }
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(board[r][c]==0){   
                    answer++;
                }
            }
        }
                

        return answer;
    }
}