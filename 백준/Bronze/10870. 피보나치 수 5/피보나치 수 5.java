import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int n,answer;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		
		fac(n);
		System.out.println(answer);
	}//main
	
	public static int fac(int n) {
		if(n<=1) {
			answer = n;
			return answer;
		}
		
		answer = fac(n-1)+fac(n-2);
		return answer;
	}//fac
	

}//class

