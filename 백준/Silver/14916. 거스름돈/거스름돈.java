import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static int [] dp;
	public static int INF = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		dp = new int [100001];
		
		dp[0]=0;
		dp[1]=INF;
		dp[2]=1;
		dp[3]=INF;
		dp[4]=2;
		dp[5]=1;

		for(int i=6; i<=N; i++) {
			if(dp[i]!=INF) {
				dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;	
			}else {
				dp[i]=INF;
			}
			
		}
		
		if(dp[N]==INF) {
			System.out.println(-1);
		}else {
			System.out.println(dp[N]);
		}
		
	}//main
}//class
