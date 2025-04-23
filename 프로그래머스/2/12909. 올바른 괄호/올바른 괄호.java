class Solution {
    boolean solution(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false; // 닫는 괄호가 더 많음
            }
        }

        return count == 0;
    }
}
