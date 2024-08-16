class Solution {
    public String solution(String my_string, int n) {
        
        String answer = "";
        
        // StringBuilder를 사용해서 특정 문자 반복한 다음 문자열로 변환하여 반환
        StringBuilder sb = new StringBuilder();
        
        // 각 문자를 n번 반복
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);  // 현재 문자
            
            for (int j = 0; j < n; j++) {
                sb.append(c);  // 문자를 n번 추가
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}
