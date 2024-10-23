import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
n : 양의 정수
F(n) : n의 각 자리 수 a에 대해서 그 수를 (9-a)로 바꾼 것
가장 큰 자리수의 유효숫자보다 앞에 등장하는 0들은 무시한다.
9의 반전은 0, 91의 반전은 8, 124의 반전은 875, 990의 반전은 9

사랑스러움 : n * F(n)

입력 : N
출력 : 1이상 N이하인 수들의 '사랑스러움' 중 최댓값
 */

public class Main {
    public static long t, n, result, a, answer, middle, digit;
    public static long multiplier = 1L;
    public static long max = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Long.parseLong(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Long.parseLong(br.readLine());
            answer = findMaxLovely(n);
            System.out.println(answer);
        }
    }

    // n의 반전을 구하는 메서드
    public static long Banjeon(long n) {
        result = 0L;
        multiplier = 1L;

        // n의 각 자릿수에 대해 9에서 뺀 값을 구해 반전값을 계산
        while (n > 0) {
            a = n % 10;
            long reverseNumber = 9 - a;
            result += reverseNumber * multiplier;
            multiplier *= 10;
            n /= 10;
        }

        return result;
    }

    // 주어진 n에서 사랑스러움의 최댓값을 구하는 함수
    public static long findMaxLovely(long n) {
        max = n * Banjeon(n); // n과 반전값을 곱한 값
        middle = getMiddleValue(n); // 자릿수에 따른 중간값 계산

        // 중간값이 n보다 크다면, n의 자릿수 마지막 값으로 계산하도록 변경
        if (middle > n) {
            middle = n;  // 중간값이 n을 넘지 않도록 처리
        }

        // n과 자릿수 중간값의 사랑스러움을 비교해 더 큰 값 선택
        max = Math.max(max, middle * Banjeon(middle));

        return max;
    }

    // 자릿수에 따라 중간값을 구하는 함수
    public static long getMiddleValue(long n) {
        int digitCount = Long.toString(n).length();  // 자릿수 계산
        return (long) Math.pow(10, digitCount - 1) * 5;  // 자릿수에 따른 중간값 계산
    }
}
