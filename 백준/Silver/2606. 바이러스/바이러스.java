

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M , s, e;
	public static int cnt =0; 
	public static int [][] adjArr = new int [N+1][N+1];
	public static boolean [] visited; 
	static Queue<Integer> que = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//컴퓨터 = 정점, 네트워크 연결 = 간선
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjArr = new int [N+1][N+1];
		visited = new boolean [N+1];
		
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			adjArr[s][e] = adjArr[e][s] = 1;	
		}
		
        //1번 컴퓨터부터 
		cnt = bfs(1);
		
		System.out.println(cnt);
		
	}//main 
	
    //return값을 int 로 줘야함.
	public static int bfs(int s) {
		que.add(s);
		visited[s] = true;
		
		while(!que.isEmpty()) {
			s = que.poll();

			for(int i=1; i<N+1; i++) {
				if(!visited[i] && adjArr[s][i]==1) {
					que.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
		
	}//bfs
	
	
	
	
	
}//class
