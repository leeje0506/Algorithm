import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



class Node{
	int r;
	int c;
	int cnt;
	boolean check;
	
	public Node(int r, int c , int cnt, boolean check) {
		this.r =r;
		this.c = c;
		this.cnt = cnt;
		this.check = check;
	}
}

public class Main {
	//N X M 맵
	//0 : 이동할 수 있는 벽, 1 : 이동할 수 없는 벽
	//(1,1)부터 (N,M)까지 이동. (최단 거리로)
	//벽을 1개까지 부수고 이동할 수 있다. 
			
	//이동 가능한 칸 상하좌우 4방향
	
	public static int N, M, answer;
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};
	public static int [][] map;
	public static boolean [][][] checked; 
	public static Queue<Node> que;
	public static StringBuilder sb = new StringBuilder();
	public static boolean finish;
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //r
		M = Integer.parseInt(st.nextToken()); //c
		
		map = new int [N][M];
		checked = new boolean [2][N][M];   //0 : 벽 안 부수고 지나감, 1 : 벽 부수고 지나감
		
		for(int r=0; r<N; r++) {
			String[] str = br.readLine().split("");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}//맵 입력		
		
		checked = new boolean[2][N][M];
		checked[0][0][0] = true;
		checked[1][0][0] = true;
		
		
		bfs();
		
		if(finish == false) {
			answer = -1;
		}else {
			answer = answer;
		}
		
		System.out.println(answer);
	}//main
	
	
	
	
	
	//벽을 마주치면 한번은 벽을 부술 수가 있음.
		//경로가 더 짧아진다면?..?
		//=> 음~~
		//예제1) (1,1)으로 갈 건데 갈 수 있는 곳이 다 벽이면 무조건 하나는 부숴야 도달할 수 있음.
		//예제2) 벽 하나 부숴도 또 벽으로 둘러 쌓여서 못 감. 
	public static void bfs() {
		
		finish = false;
		//큐 초기화
		que = new LinkedList<>();
		//시작지점 큐에 add
		que.add(new Node (0,0,1,false));  
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			//도착지점에 도착
			if(node.r == N-1 && node.c == M-1) {
				finish = true;
				answer = node.cnt;
				
				return;
			}
			
			//4방향
			for(int d=0; d<4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				//이 부분 빼먹어서 한번 틀림.
				int ncnt = node.cnt +1;
				//범위 안에서만 
				if(nr>=0 && nc>=0 && nr<N && nc<M) {
					
					//다음 칸이 벽이 아님.
					if(map[nr][nc]==0) {
						//벽 부수지 않고 진행한 경우
						if(node.check == false) {
							if(checked[0][nr][nc]==true) {
								continue;
							}else {
								checked[0][nr][nc] = true;
								que.add(new Node(nr,nc,ncnt,false));
							}
						}else {
							//벽 부수고 진행한 경우(중간에 벽을 만남)
							if(checked[1][nr][nc]==true) {
								continue;
							}else {
								checked[1][nr][nc] = true;
								que.add(new Node(nr,nc,ncnt,true));
							}
						}
						
					}else { //다음 칸이 전부 벽임.
						if(node.check == false) {
							checked[1][nr][nc] = true;
							que.add(new Node(nr,nc,ncnt,true));
						}
					}
				}
			}
				
		}

	}//bfs
	
	
	
	
	
}//class