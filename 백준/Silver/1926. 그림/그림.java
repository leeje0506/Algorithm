import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//가로, 세로로 연결된 것은 연결된 그림 => 상하좌우
	//대각선으로 연결된 것은 떨어진 그림.
	
	public static int N, M, maxSize;
	public static int [][] board = new int[N][M];
	public static boolean[][] checked;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //도화지의 세로
		M = Integer.parseInt(st.nextToken()); //도화지의 가로
		board = new int[N][M]; //도화지
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		checked = new boolean[N][M];
		int cnt=0;
		int max=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				//그림이 그려져있고, 방문하지 않은 경우
				if(board[r][c] ==1 && checked[r][c]==false) {
					maxSize=1;
					dfs(r,c);
					cnt++;
					max = max<maxSize?maxSize:max;
				}
			}
		}
		
		//출력
		//그림의 개수
		//그 중 가장 넓은 그림의 넓이 (그림이 하나도 없는 경우  = 0)	
		System.out.println(cnt);
		System.out.println(max);
		
	}//main
	
	
	public static void dfs(int r, int c) {
        checked[r][c]=true;
         
        for(int i=0; i<4; i++) {
            int nr=r+dr[i];
            int nc=c+dc[i];
             
            if(nr>=0 && nr<board.length && nc<board[0].length && nc>=0 && !checked[nr][nc] && board[nr][nc]!=0) {
            	dfs(nr, nc);
            	maxSize++;
            	
            }
            	
        }
    }//dfs
	
}//class