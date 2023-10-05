import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int T, N, M, K, start, end;
	public static int [][] map;
	public static boolean [][] visited;
	public static int cnt=0;
	public static int [] dr = {-1,-1,0,1,1,1,0,-1};
	public static int [] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); 
			N = Integer.parseInt(st.nextToken()); 
			
			map = new int [N][M];
			visited = new boolean [N][M];
			
			if(N ==0 && M ==0) {
				break;
			}
					
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
//				String str = br.readLine();
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken()); 
//					map[r][c] = str.charAt(c)-'0';
				}
			}
				
			cnt =0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(!visited[r][c] && map[r][c] ==1) {
						dfs(r,c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}//while
	}//main
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0&& nc>=0&& nr<N && nc<M && !visited[nr][nc] && map[nr][nc] ==1) {
				dfs(nr,nc);
				
			}
		}
	}

}//class
