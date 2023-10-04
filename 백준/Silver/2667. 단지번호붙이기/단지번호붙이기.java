import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static int [] dr= {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static int [][] map = new int [25][25]; //전체 입력용
	public static boolean [][] visited = new boolean [25][25]; //방문 처리용
	public static int [] cnt = new int [25*25]; //단지 수를 저장할 배열
	public static int apart_cnt=0;
	public static int N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //지도의 크기
		
		map = new int [N][N];
		visited = new boolean [N][N];
//		cnt = new int [N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		for (int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] ==1 && !visited[r][c]) {
					apart_cnt++;
					dfs(r,c);
				}
			}
		}
		Arrays.sort(cnt);
		System.out.println(apart_cnt);//총 단지 수
		
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i] != 0) {
				System.out.println(cnt[i]);
			}
		}
		
	}//main
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt[apart_cnt]++;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nc>=0 && nr<N && nc<N && visited[nr][nc]==false && map[nr][nc]==1 ) {
				dfs(nr,nc);
			}
		}
	}
}//class
