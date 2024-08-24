class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] sb = s.split(" ");
        
        for (int i = 0; i < sb.length; i++) {
            if (sb[i].equals("Z")) {
                // Z가 첫 번째 요소가 아닌지 체크
                if (i > 0) {
                    answer -= Integer.parseInt(sb[i - 1]);
                }
            } else {
                answer += Integer.parseInt(sb[i]);
            }
        }
        return answer;
    }
}
