import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;





public class Main {
	
	public static int N, M, r, c, dir, cnt;
	public static int [][] room;
	
	//북동남서
	public static int [] dr = {-1,0,1,0};
	public static int [] dc = {0,1,0,-1};

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		room = new int [N][M];
		cnt = 1; //시작지점은 항상 청소 X
		
		 st = new StringTokenizer(br.readLine());
		 r = Integer.parseInt(st.nextToken()); 
		 c = Integer.parseInt(st.nextToken()); 
		 dir = Integer.parseInt(st.nextToken());  //바라보고 있는 방향
		 
		 for(int r=0; r<N; r++) {
			 st = new StringTokenizer(br.readLine());
			 for(int c=0; c<M; c++) {
				 room[r][c] = Integer.parseInt(st.nextToken()); 
			 }
		 }//입력 끝
		 
		 clean(r,c,dir);
		 System.out.println(cnt);
	}//main
	
	public static void clean(int r, int c, int dir) {
		
		//현재 위치 청소
		room[r][c] = -1;
		
		//청소하기(청소 안 한 구역 찾아서 청소)
		for(int d=0; d<4; d++) {
			//회전하면서 (왼쪽, 반시계)
			dir = (dir+3)%4;
			int nr = r+dr[dir];
			int nc = c + dc[dir];
			//범위 안에서 
			if(nr>=0 && nc>=0 && nr<N && nc<M) {
				//청소X인 곳
				if(room[nr][nc]==0) {
					cnt++;
					//청소 호출
					clean(nr,nc,dir);
					
					return;
				}

			}

		}
		
		//바라보는 방향을 기준으로 
		int back = (dir+2)%4;  //후진 (서로 반대로)
		int br = r+dr[back];
		int bc = c + dc[back];
		//범위 안에서 
		if(br>=0 && bc>=0 && br<N && bc<M) {
			//청소 된 곳..? 아니지 그게 아니고 벽이 아니어야 함!
			if(room[br][bc]!=1) {
				clean(br,bc,dir);
			}
		}
		
	}//clean
	
	
}//class
