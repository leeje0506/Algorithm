import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long answer;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		fac(N);
		System.out.println(answer);
	}//main
	
	public static long fac(int n) {
		if(n<=1) {
			answer = 1;
			return answer;
		}
		answer = n*fac(n-1);
		return answer;
	}
}//class
