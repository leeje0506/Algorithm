

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	//가중치가 없는 무방향 그래프
    //인접행렬 
	
	public static int [][] graph;
	public static boolean []visited;
	
	public static int N, M, s, e;
	public static int ans, cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  //정점의 수
			M = Integer.parseInt(st.nextToken());  //간선의 수
			
			graph = new int [N+1][N+1];
			visited = new boolean[N+1];
			ans =0;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());  //시작정점
				e = Integer.parseInt(st.nextToken());  //끝 정점
				
				//무향
				graph[s][e] = graph[e][s] =1;
			}
			
			for(int i=1; i<N+1; i++) {
//				visited = new boolean[N+1];
				visited[i] = true;
				back(i, 1);
				visited[i] = false;
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}//tc for
		
		
	}//main
	
	
	public static void back(int idx, int cnt) {
		 if(ans<cnt){
	            ans = cnt;
	     }
	        
		
		for(int i=1; i<N+1; i++) {
			if(graph[idx][i]==1 && visited[i]==false) {
				visited[i] = true;
				back(i, cnt+1);
				visited[i] = false;
			}
			
		}
	}//back
}//class
