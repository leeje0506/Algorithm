class Solution {
    public int solution(int n) {
        int i = 1;
        int factorial = 1;

        // 반복적으로 팩토리얼을 계산하면서 n 이하인지 확인
        while (factorial <= n) {
            i++;
            factorial *= i;
        }

        // 마지막으로 factorial이 n을 초과하게 되는 시점에서 i-1을 반환
        return i - 1;
    }
}
