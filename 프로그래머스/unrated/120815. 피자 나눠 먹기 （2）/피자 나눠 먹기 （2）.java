import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static int gcd(int a, int b) {  // 최대공약수를 구하는 함수
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {  // 최소공배수를 구하는 함수
        return a * b / gcd(a, b);
    }

    public int solution(int n) throws IOException {
        int answer = lcm(n, 6) / 6;  // n과 6의 최소공배수를 구하고, 그 값을 6으로 나눔

        return answer;
    }
}
