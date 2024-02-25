import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람들 몸무게 오름차순 정렬
        Arrays.sort(people);
        int answer = 0; // 사용할 구명보트의 수
        int i = 0; // 가장 가벼운 사람
        int j = people.length - 1; // 가장 무거운 사람
        
        // 가벼운 사람부터 시작해서 무거운 사람까지 검사
        while (i <= j) {
            // 몸무게 합이 무게 제한 이하인 경우
            if (people[i] + people[j] <= limit) {
                // 모두 구명보트에 태움
                i++; // 다음으로 가벼운 사람으로 이동
            }
            // 무게 제한을 초과 or 한 사람만 태운 경우
            j--; // 다음으로 무거운 사람으로 이동
            answer++; // 구명보트 추가
        }
        
        // 필요한 구명보트 수 반환
        return answer; 
    }
}
