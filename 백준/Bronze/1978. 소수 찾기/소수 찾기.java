import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수의 개수 N 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (PrimeCheck(num)) {
                count++;
            }
        }
        System.out.println(count);  // 소수의 개수 출력
    }

    public static boolean PrimeCheck(int num) {
        if (num < 2) return false;  // 1은 소수가 아님
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;  // 나누어 떨어지면 소수가 아님
        }
        return true;  // 나누어 떨어지는 수가 없으면 소수임
    }
}
