class Solution {
    public int solution(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i는 n의 약수
                if (i != n / i) {
                    count++; // n/i도 n의 약수
                }
            }
        }

        return count;
    }
}
