import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        // 배열을 오름차순으로 정렬
        Arrays.sort(numbers);
        
        // 가장 큰 두 숫자를 곱함
        int maxProduct = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        
        return maxProduct;
    }
}
