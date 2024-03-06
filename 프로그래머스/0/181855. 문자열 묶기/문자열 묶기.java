import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] strArr) {
        // 문자열의 길이를 키로, 해당 길이의 문자열 개수를 값으로 하는 맵 생성
        Map<Integer, Integer> lengthCountMap = new HashMap<>();

        // 주어진 문자열 배열을 순회하며 맵 업데이트
        for (String str : strArr) {
            int length = str.length();
            lengthCountMap.put(length, lengthCountMap.getOrDefault(length, 0) + 1);
        }

        // 맵을 순회하며 가장 큰 값을 찾음
        int maxGroupSize = 0;
        for (int count : lengthCountMap.values()) {
            if (count > maxGroupSize) {
                maxGroupSize = count;
            }
        }

        // 가장 많은 원소를 가진 그룹의 크기 반환
        return maxGroupSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strArr = {"a", "bc", "d", "efg", "hi"};
        System.out.println(solution.solution(strArr)); // 결과 예시: 2
    }
}
