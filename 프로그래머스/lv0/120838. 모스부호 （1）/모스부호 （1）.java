import java.lang.StringBuilder;
class Solution {
    public String solution(String letter) {
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] alp = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        StringBuilder sb = new StringBuilder();
        for (String s: letter.split(" ")) {
            for (int i = 0; i < str.length; i++) {
                if (s.equals(str[i])) {
                    sb.append(alp[i]);
                }
            }
        }
        String answer = sb.toString();
        return answer;
    }
}