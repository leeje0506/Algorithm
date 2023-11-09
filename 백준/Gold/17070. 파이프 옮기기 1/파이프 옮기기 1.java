

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int [][] map;
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		
		for(int r=1; r<N+1; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=1; c<N+1; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				
			}
		}//map 입력
		
		//가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있다
		//시작은 r=1, c=2, dir=0
		dfs(1, 2, 0);
		
		System.out.println(cnt);
		
	}//main

	 //dir이 0이면 가로 1이면 세로 2면 대각선
	public static void dfs(int r, int c, int dir) {
		
		if(r>N || c>N || map[r][c] == 1)
            return;
		
		
        
		
		//대각선
        if(dir == 2){
        	//파이프 끝 점에 벽이 있으면 리턴
            if(map[r][c-1] == 1 || map[r-1][c] == 1)
                return;
        }
        
      //끝 지점에 도달하면 cnt++
      	if(r == N && c == N){
      		cnt++;
            return;
        }
        
        if(dir == 0){
            dfs(r, c+1, 0);
            dfs(r+1, c+1, 2);
        }
        
        else if(dir == 1){
            dfs(r+1, c, 1);
            dfs(r+1, c+1, 2);
        }
        
        else{
            dfs(r+1, c+1, 2);
            dfs(r, c+1, 0);
            dfs(r+1, c, 1);
        }
		
	}//dfs
	
}//class
