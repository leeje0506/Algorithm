import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double [] score = new double [N];
		double [] newScore= new double [N];
		double max =0;
		double answer=0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			score[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, score[i]);
		}
		
		for(int i=0; i<N; i++) {
			newScore[i] = (score[i]/max) *100;
			answer += newScore[i];
		}
		
		answer = answer/(newScore.length);
		
		System.out.println(answer);
	}
}
