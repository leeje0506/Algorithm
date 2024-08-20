class Solution {
    public int solution(int[] numbers, int k) {
        // 첫 번째로 공을 던지는 사람의 위치를 0으로 설정
        int position = 0;
        
        // k번 공을 던질 때까지 반복
        for (int i = 1; i < k; i++) {
            position = (position + 2) % numbers.length;  // 배열의 길이를 초과하지 않도록 나머지 연산 사용
        }
        
        // k번째 공을 던진 사람의 번호 반환
        return numbers[position];
    }
}
