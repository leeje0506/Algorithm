import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이거 어제 뭐라고 생각했더라..
//아악~~~~~~~~ 고민해서 쓴 건데.. 어디갔어.. 돌려줘요ㅜㅜㅜ

//오름차순? 재귀를 돌면서 다음을 무조건 다음 숫자(큰 숫자)로 보게 만들면 되나?
//아니면서 아예 처음부터 오름차순으로 뽑아버릴 수는 없는 걸가?
//사실 저게 둘 다 똑같은 말일지도...
//그럼 방문 체크가 필요 없는 거 아닌가. 어차피 다음 숫자로 볼 거고 앞에 지나간 애들은 안 보니까.

public class Main {
	public static int N, M;
	public static int [] num;
	public static boolean [] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int [N+1];
		
		back(0,1);
		System.out.println(sb);
		
	}//main
	
	//그럼 파라미터를 idx(깊이)뿐 아니고 숫자가 커지는 것도 받아줘야 하는 건가
	//어떻게 함..어떻게 주지.. 고민 고민
	public static void back (int idx, int point) {
		
		//종료조건
		if(idx == M) {
			for(int n=0; n<M; n++) {
				sb.append(num[n]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=point; i<N+1; i++) {
			//조건
			num[idx] = i;
			back(idx+1, i+1);
		}
				
	}//back
	
}//class
