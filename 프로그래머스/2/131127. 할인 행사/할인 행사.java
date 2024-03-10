import java.util.HashMap;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();

        // 원하는 제품과 수량을 wantMap에 저장
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(wantMap);

            // 10일 간 할인하는 제품 확인
            for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                tempMap.put(product, tempMap.getOrDefault(product, 0) - 1);
            }

            // 원하는 제품을 모두 할인 받을 수 있는지 확인
            if (canGetAllDiscounts(tempMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean canGetAllDiscounts(HashMap<String, Integer> tempMap) {
        for (int value : tempMap.values()) {
            if (value > 0) {
                return false; // 원하는 수량보다 적게 할인 받은 경우
            }
        }
        return true; // 모든 원하는 제품을 할인 받은 경우
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution.solution(want, number, discount)); // 출력: 3
    }
}
