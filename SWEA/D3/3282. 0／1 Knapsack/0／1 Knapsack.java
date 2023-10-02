
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int T, N, K, v, c;
	public static int [][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine()); // tc
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //개수 
			K = Integer.parseInt(st.nextToken()); //부피 
			
			int [] weights = new int [N+1];
			int [] cost = new int [N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				weights[i] = Integer.parseInt(st.nextToken()); //부피  
				cost[i]= Integer.parseInt(st.nextToken()); //가치  
			}//입력 끝 
			
			dp = new int [N+1][K+1];
			
            //범위 잘 줘야함
			for(int n=1; n<=N; n++) {
				for(int w=0; w<=K; w++) {
                    //여기도
					if(weights[n] <=w) {
						dp[n][w] = Math.max(dp[n-1][w], dp[n-1][w-weights[n]] + cost[n]);
					}else {
						dp[n][w] = dp[n-1][w];
					}
				}
			}
			System.out.println("#" + tc + " " + dp[N][K]);
		}//tc for		
	}//main
	
}//class
