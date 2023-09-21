
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	
	//인접 행열 이용  
	static int N, M, s, e, answer;
	static int [][] adjArr = new int [N+1][N+1];
	static boolean [] visited; 
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수 
		M = Integer.parseInt(st.nextToken()); //간선의 개수 

		adjArr = new int [N+1][N+1];
		visited = new boolean [N+1];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());  //시작정점 
			e = Integer.parseInt(st.nextToken());  //끝정점 
			
			//무향 그래프 
			adjArr[s][e] = 1;
			adjArr[e][s] = 1; //가중치 없음 = 1
		}
			//방문 체크 
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}//main
		
		
	//dfs
	public static void dfs(int s) {
		visited[s] = true;
		
		for(int i=1; i<N+1; i++) {
			if(!visited[i] && adjArr[s][i]==1) {
				dfs(i);
			}
		}
	}
	
}//class 
