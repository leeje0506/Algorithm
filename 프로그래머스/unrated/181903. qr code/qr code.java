
class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();  // 문자열을 빌드하는 데 사용할 StringBuilder

        int len = code.length();
        for (int i = 0; i < len; i++) {
            if( i % q == r){  // i를 q로 나눈 나머지가 r인 경우
                sb.append(code.charAt(i));  // code의 i번째 문자를 StringBuilder에 추가
            }
        }

        String answer = sb.toString();  // StringBuilder의 내용을 문자열로 변환

        return answer;
    }
}
