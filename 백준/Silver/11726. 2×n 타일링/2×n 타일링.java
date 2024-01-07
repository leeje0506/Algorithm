import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    // MOD 상수 정의 (문제에서 주어진 나머지 값)
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 타일링 방법의 수를 저장할 배열 선언
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 1; // 직사각형이 없는 경우도 1가지 방법이 있음을 의미
        dp[1] = 1;

        // 점화식을 이용하여 dp 배열 채우기
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        // 결과 출력
        bw.write(String.valueOf(dp[n]));
        bw.flush(); // 버퍼에 남아있는 데이터를 모두 출력

        br.close();
        bw.close();
    }
}
