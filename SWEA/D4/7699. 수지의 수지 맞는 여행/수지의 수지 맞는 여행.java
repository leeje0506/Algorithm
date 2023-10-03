import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int R, C, answer;
	public static char [][] island;
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static boolean []visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			island = new char [R][C];
			visited = new boolean [26];
			
			for(int r=0; r<R; r++) {
				String str = br.readLine();
				for(int c=0; c<C; c++) {
					island[r][c] = str.charAt(c);
				}
			}//입력 끝
			answer =0;
			visited = new boolean [26];
			visited[island[0][0]-'A'] = true;
			
			dfs(0,0,1);
			System.out.println("#" + tc + " " + answer);
		}//tc for문

	}//main

	public static void dfs(int r, int c, int cnt) {
		
		
		//기저조건
		if(cnt > answer) {
			answer = cnt;			
		}
		
		//4방향 
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			//범위를 벗어나지 않고, 방문하지 않은 곳
			if(nr>=0 && nc>=0 && nr<R && nc<C && visited[island[nr][nc] - 'A']==false) {
				visited[island[nr][nc]-'A']=true; //방문처리
				dfs(nr,nc, cnt+1);
				visited[island[nr][nc]-'A']=false; //다시 방문처리 false
			}
		}
	}
}//class
