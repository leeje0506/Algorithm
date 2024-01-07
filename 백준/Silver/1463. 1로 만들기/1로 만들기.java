import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        // 초기 조건 설정
        dp[1] = 0;

        // 점화식을 이용한 DP 배열 채우기
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 뺀 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누어 떨어지는 경우
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누어 떨어지는 경우
        }

        // 결과 출력
        bw.write(String.valueOf(dp[N]));
        bw.flush(); // 버퍼를 비워줍니다.

        // 사용한 자원을 해제
        br.close();
        bw.close();
    }
}
