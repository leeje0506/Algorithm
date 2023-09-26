import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int [] std = new int [N];
			double total=0;
			for(int i=0; i<N; i++) {
				std[i] = Integer.parseInt(st.nextToken());
				total += std[i];
			}
			total = total/N;
			
			double cnt=0;
			for(int i=0; i<N; i++) {
				if(std[i]>total) {
					cnt++;
				}
			}
			
			double answer = (cnt/N)*100;
			System.out.println(String.format("%.3f", answer) +"%");

		}//tc for
	}//main
		
}//class
