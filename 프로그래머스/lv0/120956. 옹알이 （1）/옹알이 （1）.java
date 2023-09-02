class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("aya") || babbling[i].contains("ye") || babbling[i].contains("woo") || babbling[i].contains("ma")) {
                babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma", "");
            }
            if (babbling[i].equals("")) {
                answer++;
            }
        }
        return answer;
    }
}