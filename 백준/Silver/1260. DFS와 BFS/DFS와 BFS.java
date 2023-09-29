import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	
    static StringBuilder sb = new StringBuilder();

	static int N,M,V,s,e;
	static int [][] arr;
	static boolean [] visited;
	static Queue<Integer> que = new LinkedList<>();
   
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
        
        arr = new int[N+1][N+1];
        visited = new boolean [N+1];
     
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	s = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	
        	//무향 그래프(양방향)
        	arr[s][e] = arr[e][s] = 1;
        }//두 정점 입력
        
        dfs(V);
        sb.append("\n");
        visited = new boolean [N+1];
        
        bfs(V);
        
        System.out.println(sb);

    }//main
    
    public static void dfs(int V) {
    	visited[V] = true;
    	sb.append(V + " ");
    	
    	for(int i=0; i<N+1; i++) {
    		if(!visited[i] && arr[V][i] == 1) {
    			dfs(i);
    		}
    	}
    }//dfs
    
    public static void bfs(int V) {
    	que.add(V);
    	visited[V] = true;
    	
    	while(!que.isEmpty()) {
    		V = que.poll();
    		sb.append(V + " ");
    		
    		for(int i=1; i<N+1; i++) {
    			if(!visited[i] && arr[V][i]==1) {
    				que.add(i);
    				visited[i] = true;
    			}
    		}
    	}
    }//bfs
    
}//class