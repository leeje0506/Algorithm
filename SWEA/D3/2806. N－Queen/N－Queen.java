import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

	public static int T, N, answer;
	//public static boolean [][] visited;
	public static int [] check;
	//public static int[] dr = { -1, 0, 1, 0, 1, -1, 1, -1 };
    //public static int[] dc = { 0, 1, 0, -1, -1, -1, 1, 1 };
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			//visited = new boolean [N][N];
			check = new int [N];
			answer =0;
			
			dfs(0);
			System.out.println("#" + tc + " " + answer);
			
		}//tc for문

	}//main
	
	//놓을 수 있는지 확인
	public static boolean possible (int r, int c) {
		for(int i=0; i<r; i++) {
			//수직, 대각선에 있다면 놓을 수 없다.
			if(check[i] == c || Math.abs(c-check[i])==(r-i)) {
				return false;
			}
		}
		return true;
	}//possible
	
	public static void dfs(int depth) {

		//종료조건
		if(depth == N) {
			answer++;
			return;
		}
		
		//한 줄에 하나씩
		for(int i=0; i<N; i++) {
			//놓을 수 있는 자리
			if(possible(depth,i)) {
				check[depth]=i;
				dfs(depth +1);
			}
		}
	}//dfs

}//class