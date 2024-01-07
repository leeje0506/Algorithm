public class Solution {
    public int solution(int n) {
        for (int x = 2; x < n; x++) {
            if(n % x == 1){ 
                 return x;
            }
        }
        // n-1은 항상 n을 나누어 나머지가 1이 되므로, 만약 위의 for문에서 결과를 찾지 못했다면, n-1을 반환합니다.
        return n-1;
    }
}
