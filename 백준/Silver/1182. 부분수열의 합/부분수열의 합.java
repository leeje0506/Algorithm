import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, target;
    static int cnt;
    static int[] arr;

    public static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == target) {
                cnt++;
            }
            return;
        }

        // 현재 원소를 더한 경우
        dfs(idx + 1, sum + arr[idx]);

        // 현재 원소를 더하지 않은 경우
        dfs(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // 목표 합이 0일 경우 1을 뺄 거임
        if (target == 0) {
            cnt--; 
        }

        System.out.println(cnt);
    }
}
