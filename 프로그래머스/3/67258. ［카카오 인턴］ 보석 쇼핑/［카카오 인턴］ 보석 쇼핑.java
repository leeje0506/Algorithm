import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {
        // 보석의 종류 파악
        HashSet<String> gemSet = new HashSet<>();
        for(String gem : gems) {
            gemSet.add(gem);
        }
        int gemKind = gemSet.size();
        
        HashMap<String, Integer> gemMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int[] answer = {0, gems.length - 1}; // 시작과 끝 위치를 저장할 배열 초기화
        int minLen = Integer.MAX_VALUE;
        
        // 슬라이딩 윈도우 알고리즘 적용
        while(true) {
            // 모든 종류의 보석을 포함할 때까지 end를 이동
            if(gemMap.size() < gemKind) {
                if(end == gems.length) break; // 끝에 도달했으면 종료
                gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
                end++;
            } else { // 모든 종류의 보석을 포함하고 있을 때
                if(end - start < minLen) { // 더 짧은 구간을 찾았으면 갱신
                    minLen = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                // start를 이동시키며 구간 축소
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                if(gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]);
                }
                start++;
            }
        }
        
        // 가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호 반환
        return answer;
    }
}
