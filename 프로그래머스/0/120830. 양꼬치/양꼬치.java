class Solution {
    public int solution(int n, int k) {
        // 무료 음료수 개수 계산
        int freeDrinks = n / 10;
        
        // 최종 금액 계산
        int answer = (12000 * n) + (2000 * (k - freeDrinks));
        
        return answer;
    }
}
