import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    //백트래킹
	
	static int N, M ;
	static int[] num = new int[M];
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
//		adjArr = new int [N+1][N+1];
		num = new int[N+1];
		visited = new boolean [N+1];
		
		dfs(0);
		System.out.println(sb);
	}//main

	
	//dfs
	public static void dfs(int idx) {
		//멈추기
		if(idx== M) {
			for(int j=0; j<M; j++ ) {
				sb.append(num[j]).append(" ");
			}
			sb.append("\n");
			return;
			
		}
		for(int i=1; i<N+1; i++) {
		    //다시 뽑지 않게끔 하면 된다.
			visited[i] = true;
			num[idx] =i;
			dfs(idx+1);  //재귀  
			visited[i] = false;
		}
	}
	


}//class
