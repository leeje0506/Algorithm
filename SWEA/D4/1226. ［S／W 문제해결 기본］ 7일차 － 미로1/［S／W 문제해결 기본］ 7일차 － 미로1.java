

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	//갈 수 있는지만 보면 됨  > dfs 사용
	//범위 잘 주기
	//종료 조건 
	
	public static int [][] map;
	public static boolean [][] visit;
	public static int [] dr = {-1,1,0,0,};
	public static int [] dc = {0,0,1,-1};
	public static int answer;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine()); //테케 번호
			
			map = new int[16][16];
			visit = new boolean[16][16];
			
			for(int r=0; r<16; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), "1||0", true);
				for(int c=0; c<16; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}//입력 끝
			
			answer=0;
			dfs(1,1);
			System.out.println("#" + tc + " " + answer);
		}//tc for
	}//main
	
	public static void dfs (int s, int e) {
        //3 도착지점. 도착하면 answer=1 반환하고 종료.
		if(map[s][e]==3) {
			answer = 1;
			return;
		}
        //방문 완~
		visit[s][e]=true;
		
		
		for(int d=0; d<4; d++) {
			int nr = s + dr[d];
			int nc = e + dc[d];
            //범위 안에 있고, 방문처리 되어있지 않으면서, 1(벽)이 아닌 곳만 탐색
			if(nr>=0 && nr < 16 && nc>=0 && nc<16 && visit[nr][nc]== false && map[nr][nc]!=1) {
				dfs(nr, nc);
			}
		}
        //탐색이 끝났으면 방문처리 다시 false
		visit[s][e] = false;
	}//bfs
}//class
