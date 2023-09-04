class Solution {
    public String solution(String s) {
        String answer = "";
        char[] c = new char[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1) sb.append((char) (i + 97));
        }

        answer = sb.toString();
        return answer;
    }
}