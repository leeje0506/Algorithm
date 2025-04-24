import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. 각 귤 크기별로 빈도수를 세는 맵
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        // 2. 빈도수 내림차순 + 크기 내림차순 정렬
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        sortedList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // 빈도 수 내림차순
            }
            return b.getKey() - a.getKey();         // 빈도 같으면 크기 큰 순
        });

        // 3. k개를 채우면서 종류 수 카운트
        int picked = 0;
        int kindCount = 0;

        for (Map.Entry<Integer, Integer> entry : sortedList) {
            int count = entry.getValue();

            // 이번 크기를 얼마나 담을 수 있을까?
            if (picked + count >= k) {
                kindCount++; // 마지막 하나의 종류만 더 필요함
                break;
            }

            picked += count;
            kindCount++;
        }

        return kindCount;
    }
}
