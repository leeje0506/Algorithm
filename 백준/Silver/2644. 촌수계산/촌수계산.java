import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, s, e, p, k, answer, cnt = 0;
	public static int [][] map;
	public static boolean [] check;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine()); //전체 사람 수 (정점의 개수)
		
		map = new int [N+1][N+1];
//		check = new boolean[N+1];
		
		//촌수를 계산해야하는 두 사람 정보
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); //시작 노드
		e = Integer.parseInt(st.nextToken()); //끝 노드
		
		M = Integer.parseInt(br.readLine()); //관계 수 (간선의 개수)
		
		//부모 자식간의 관계
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken()); //부모
			k = Integer.parseInt(st.nextToken()); //자식
			
            //사이를 나타내기 때문에 방향 상관없음
			map[p][k] = map[k][p] =1;
		}
		
		check = new boolean[N+1];
		
		dfs(s,e,0);
	
		if(answer == 0) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
		
	}//main
	
	
	
	public static void dfs (int s, int e, int cnt) {
		check[s] = true;
		
		if(s == e) {
			answer = cnt;
			return;
		}
		for(int i=0; i<=N; i++ ) {
			if(!check[i] && map[s][i]==1) {
				check[i] = true;
				dfs(i, e, cnt+1);
				check[i] = false;
			}
		}
	}//dfs

}//class