import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int N, M;
	public static int[] num;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[M];
 
		dfs(1, 0);
		System.out.println(sb);
 
	}
 
//시작점으로 설정할 point, 인자 넘겨줄 depth
	public static void dfs(int point, int depth) {
 
		if (depth == M) {
			for (int val : num) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = point; i <= N; i++) {
			num[depth] = i;
			dfs(i, depth + 1);
		}
 
	}
 
}