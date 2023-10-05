import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, max, cnt, h;
	public static int [][] board;
	public static boolean [][] visited;
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int [N][N];
		visited = new boolean [N][N];
		
		//최대 높이
		max=0;
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if(board[r][c] > max) {
					max = board[r][c];
				}
			}
		}//입력 끝	
		
		//최대 섬 개수
		int max_cnt=0;
		for(int h=0; h<=max; h++) {
			visited = new boolean [N][N];
			//섬 개수
			cnt=0;
			for(int r=0; r<N; r++) {
	            for(int c=0; c<N; c++) {
	                if(!visited[r][c] && board[r][c] >h) {
//	                    dfs(r,c,h);
//	                    cnt++;
	                	cnt += dfs(r,c,h);
	                	
	                }
	            }
	        }
			max_cnt = Math.max(max_cnt, cnt);
		}
		System.out.println(max_cnt);
		
		
	}//main
	
	
	//높이
	public static int dfs(int r, int c, int height) {
		visited[r][c] =true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc] && board[nr][nc] >height) {
				visited[nr][nc] = true;
				dfs(nr,nc, height);
				
			}
		}
		return 1;
	}//dfs

}//class
