class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minMove = len - 1; // 최소 좌우 이동 횟수
        
        for (int i = 0; i < len; i++) {
            // 상하 조작 횟수
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            // 다음 문자로 넘어가며 연속된 A의 최대 길이 찾기
            int nextIndex = i + 1;
            while (nextIndex < len && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            
            // 좌우 이동 최소화 계산
            minMove = Math.min(minMove, i + len - nextIndex + Math.min(i, len - nextIndex));
        }
        
        return answer + minMove;
    }
}
