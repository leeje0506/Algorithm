
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,1,-1};
	static int [][] maze = new int[100][100];
	static int [][] visited = new int [100][100];
	static int answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc =1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
		
			
			maze = new int [100][100];
			visited = new int [100][100];
			answer =0;
			
			for(int r=0; r<100; r++) {
				String line = br.readLine();
//				String str = br.readLine();
//				StringTokenizer st = new StringTokenizer(str, "");
				
				for(int c=0;c<100; c++) {
					maze[r][c] = line.charAt(c) - '0';
				}
			}
			
			
			dfs(1,1);
			
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}//main
	
	//bfs
	public static void dfs(int r, int c) {
//		visited[r][c] = false;
		
		//3 : 도착 지점  
		if(maze[r][c] == 3) {
			answer =1;
			return;
		}
//		if(answer ==1) {
//			return;
//		}
//		visited[r][c] = true;
		visited[r][c] = 1;
		
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr < 100 && nc>=0 && nc<100 && visited[nr][nc]==0 && maze[nr][nc]!=1) {
				dfs(nr, nc);	
			}
		}
		visited[r][c] = 0;
	}//bfs

}//class
