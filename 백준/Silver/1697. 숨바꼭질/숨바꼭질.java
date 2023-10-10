import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int subin, sister, answer;
	public static int [] visited = new int [100001];
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st =new StringTokenizer(br.readLine());
	
	subin = Integer.parseInt(st.nextToken());
	sister = Integer.parseInt(st.nextToken());
		
	answer = bfs(subin);
	System.out.println(answer);
	}//main
	
	
	public static int bfs(int node) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(node);
		int idx = node;
		visited[idx] =1;
		int x = 0;
		while(que.isEmpty() == false) {
			x = que.remove();
			
			if(x == sister) {
				return visited[x]-1;
			}
			//x-1
			if(x-1 >=0 && visited[x-1]==0) {
				visited[x-1] = visited[x]+1;
				que.add(x-1);
			}
			
			//x+1
			if(x+1<=100000 && visited[x+1]==0) {
				visited[x+1] = visited[x]+1;
				que.add(x+1);
			}
			//x*2
			if(x*2 <=100000 && visited[2*x] == 0) {
				visited[x*2] = visited[x]+1;
				que.add(2*x);
			}
		}//while
		return -1;		
	}//bfs
}//class
