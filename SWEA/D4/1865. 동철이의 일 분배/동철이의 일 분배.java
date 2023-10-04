import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int T, N;
	public static double [][] board;
	public static boolean [] selected;
	public static double max;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			board = new double [N][N];
			selected = new boolean [N];
			
			max =0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Double.parseDouble(st.nextToken())/100.0;
				}
			}//입력 끝
			
			
			
			back(0, 1);
			System.out.print("#" + tc + " ");
			System.out.print(String.format("%.6f", max));
			System.out.println();
			
		}//tc for문
		
	}//main
	
	public static void back(int cnt , double sum) {
		if(sum*100 <= max) {
			return;
		}
		if(cnt == N) {
			if(sum*100 > max) {
				max = sum*100;
				return;
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				back(cnt+1, sum*board[cnt][i]);
				selected[i] = false;
			}
		}
		
	}
}//class
