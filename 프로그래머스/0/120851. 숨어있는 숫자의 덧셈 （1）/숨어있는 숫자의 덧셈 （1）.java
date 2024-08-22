class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if(Character.isDigit(ch)) {  // 숫자인지 확인
                answer += Character.getNumericValue(ch);  // 문자 숫자를 int로 변환 후 더하기
            }
        }
        
        return answer;
    }
}
