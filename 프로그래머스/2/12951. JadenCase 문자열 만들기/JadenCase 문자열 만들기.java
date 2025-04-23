class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (isStart) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

            //지금 문자가 공백이면 다음 글자가 단어 시작임.
            isStart = (c == ' '); 
        }

        return sb.toString();
    }
}
