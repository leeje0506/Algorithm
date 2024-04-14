import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main { 
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 

        if (n == 1) { // n이 1일 경우
            System.out.println(1); // 1 출력
            return; // 프로그램 종료
        }

        int[] dp = new int[n + 1]; // dp 배열 선언 및 초기화
        dp[1] = 1; // 2x1 직사각형을 채우는 방법은 1가지
        dp[2] = 2; // 2x2 직사각형을 채우는 방법은 2가지

        for (int i = 3; i <= n; i++) { // 3부터 n까지 반복
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 점화식에 따라 dp값 계산 및 10007로 나눈 나머지 저장
        }

        System.out.println(dp[n]); // 계산된 dp[n] 값을 출력
    }
}
