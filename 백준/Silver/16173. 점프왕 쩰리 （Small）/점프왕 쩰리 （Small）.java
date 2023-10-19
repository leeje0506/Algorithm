import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static boolean answer;
	public static int [][] map;
	public static boolean [][] checked;
	public static int [] dr = {0,1};
	public static int [] dc = {1,0};
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		checked = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = false;
		dfs(0,0);
		
		if(answer == true) {
			sb.append("HaruHaru");
		}else {
			sb.append("Hing");
		}
		sb.append("\n");
		
		System.out.println(sb);
	}//main
	
	
	public static void dfs (int r, int c) {
		
		checked[r][c] = true;
		//종료 조건
		if(map[r][c] == -1) {
			answer = true;
			return;
		}
		
		//오른쪽, 아래로만 갈 수 있다. 
		//그 칸의 수만큼 이동해야 한다.
		for(int d=0; d<2; d++) {
			int nr = r+ dr[d] * map[r][c];
			int nc = c + dc[d] * map[r][c];
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				if(checked[nr][nc]==false && answer==false) {
					checked[nr][nc]=true;
					dfs(nr,nc);
				}
				
			}
		}
	}
}//class
