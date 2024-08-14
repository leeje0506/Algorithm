class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 분자와 분모 구하기
        int numerator = (numer1 * denom2) + (numer2 * denom1); // 분자
        int denominator = denom1 * denom2; // 분모
        
        // 기약분수 판단?
        // 최대공약수 구해서 판단.
        int gcd = gcd(numerator, denominator);
        
        // 분자와 분모를 최대공약수로 나누어 기약분수로 만든다.
        numerator /= gcd;
        denominator /= gcd;
        
        // 결과 저장
        int[] answer = {numerator, denominator};
        return answer;
    }
    
    // 최대공약수를 구하는 메서드(유클리드 알고리즘(Euclidean algorithm))
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
