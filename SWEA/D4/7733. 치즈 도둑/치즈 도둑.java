

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//치즈도둑
public class  Solution{
	//치즈 덩어리 : 상 하 좌 우 인접한 칸을 하나로 묶어놓은 것
	//회색 칸 : 요정이 냠
	//100일 중에 치즈덩어리가 가장 많을 때 덩어리 개수를 구해보기
	
	public static int T,N;
	public static int [][] board = new int [N][N]; //치즈
	public static boolean[][] visited; //방문처리
	//상 하 좌 우 
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	
	//main
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine()); //테케 번호
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine()); //치즈 한 변의 길이
			int max = 1;  //chees 무조건 1부터임... 이거부터 틀려먹음..개빡침
			int cnt=0;
			board = new int[N][N]; //위에 했어도 해줘야 한다..
			
			for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					board[r][c] = Integer.parseInt(st.nextToken()); //치즈~
				}	
			}//board에 치즈값 넣기
			
			
			//100일 동안 치즈를 먹어...
			
			for(int day=1; day<=100; day++) {
				cnt=0;
				
				visited = new boolean[N][N]; //초기화 순서 잘 보기
				check(board, day); 
				
				for(int r=0; r<board.length; r++) {
					for(int c=0; c<board[0].length; c++) {
						//방문하지 않고, 치즈 !=0
						if(visited[r][c]==false && board[r][c]!=0 ) {
							cnt++;
							direction(r, c);
						}
					}
				}
				if(max<cnt) {
					max=cnt;
				}
				
			}//100 for
			
			System.out.println("#" + tc + " " + max);
			
		}//tc for
		

	}//main
	
	//냠
	public static void check (int[][] board, int day) {
		for(int r=0; r<board.length; r++) {
			for(int c=0; c<board[0].length; c++) {
				if(board[r][c]<=day) { //초기화 저기서 할 거면 범위 이렇게 해야지 정신차려라
					board[r][c]=0;
					visited[r][c]=true; //방문처리
				}
			}
		}
	}//check
	
	
	//or,oc : 원래 r, c
	//nr,nc : dr,dc 더해서 방향 돌기
	public static void direction(int nnr, int nnc) {
        int or=nnr;
        int oc=nnc;
        int nr=0;
        int nc=0;
         
        visited[or][oc]=true;
         
        for(int i=0; i<4; i++) {
            nr=or+dr[i];
            nc=oc+dc[i];
             
            if(nr>=0 && nr<board.length && nc<board[0].length && nc>=0 && !visited[nr][nc] && board[nr][nc]!=0)
            	direction(nr, nc);
        }
    }//direction
	
	
	
}//class
