import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



//플로이드 와샬 알고리즘 (모든 정점으로의 최단거리)
//거쳐가는 정점을 기준으로 함.
//i에서 j까지, i에서 k까지, k에서 j까지 가는 것은 같다.

public class Main {
	
	public static int N;
	public static int [][] board;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine()); //정점의 개수
		
		board = new int [N][N];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
	
		//i > k 까지 갈 수 있고, k > j 까지 갈 수 있으면,
		// => i > j? : 갈 수 있음.
		for(int k=0; k<N; k++) {
			//i : 출발노드
			for(int i=0; i<N; i++) {
				//j : 도착노드
				for(int j=0; j<N; j++) {
					if(board[i][k] ==1 && board[k][j]==1) {
						board[i][j] =1;
					}
				}
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print((board[r][c] + " "));
				
			}
			System.out.println();
		}
		
		
	}//main

}//class