import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fac(N));
	}//main
	
	public static int fac(int n) {
		if(n<=1) {
			answer =1;
			return answer;
		}
		answer = n*fac(n-1);
		return answer;
	}//fac
}//class
