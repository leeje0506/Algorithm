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
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine()); //테케
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); //node
			M = Integer.parseInt(st.nextToken()); //line
			K = Integer.parseInt(st.nextToken()); //start_node
			
			map = new int [N][M];
			visited = new boolean [N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken()); //시작정점
				end = Integer.parseInt(st.nextToken()); //끝정점
				
				//두 배추의 위치가 같은 경우는 없다. 유향
				map[start][end]=1;
			}//입력 끝
			
			
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
		}//tc for
	}//main
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0&& nc>=0&& nr<N && nc<M && !visited[nr][nc] && map[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
	}

}//class
