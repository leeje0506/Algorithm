import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	
	public static int N, K, cnt;
	public static int [] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc =1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //자연수 N개
			K = Integer.parseInt(st.nextToken()); //합이 K가 되도록
			
			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt=0;
			set(0,0);
			System.out.println("#" + tc + " " + cnt);
			
		}//tc for
	}//main
	
	public static void set (int idx, int sum) {
		if(idx == N) {
			if(sum == K) {
				cnt++;
			}
			return;
		}else {
			set(idx+1, sum);
			sum+=arr[idx];
			set(idx+1, sum);			
		}
	}
}//class
