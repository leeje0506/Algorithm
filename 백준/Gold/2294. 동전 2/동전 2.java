import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static int [] dp;
	public static int [] cost;
//	public static int INF = Integer.MAX_VALUE;
	public static int INF = 100001;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		cost = new int [n];
		dp = new int [k+1];
		
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<k+1; i++) {
			dp[i] = 100001 ;
		}
		dp[0]=0;

		for(int i=1; i<k+1; i++) {
			for(int j=0; j<n; j++) {
				if(i>=cost[j]) {
					dp[i] = Math.min(dp[i], dp[i-cost[j]] +1);
				}
				
				
			}
		}
		
//		for(int i=1; i<n; i++) {
//            for(int j=cost[i]; j<k+1; j++) {
//                dp[j] = Math.min(dp[j-cost[i]], dp[j-cost[i-1]] )+1;
//                
//            }
//        }
		
		if(dp[k] == 100001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}//main
}//class
