class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder answer = new StringBuilder();
        
        // 입력된 문자열을 하나씩 순회하며 letter와 다른 경우에만 추가
        for (int i = 0; i < my_string.length(); i++) {
            String currentChar = String.valueOf(my_string.charAt(i));
            if (!currentChar.equals(letter)) {
                answer.append(currentChar);
            }
        }

        return answer.toString(); 
    }
}
