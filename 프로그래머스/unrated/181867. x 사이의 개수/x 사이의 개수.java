class Solution {
    public int[] solution(String myString) {
        //-1은 구분자를 기준으로 구분할 때, 빈 문자열까지 포함하여 반환한다는 뜻
        String[] s = myString.split("x", -1);
        
        int[] answer = new int[s.length];
        
        for (int i = 0; i < s.length; i++) {
            //answer의 i번째 원소 위치에 s의 i번째 원소의 길이만큼 할당
            answer[i] = s[i].length();
        }
        return answer; 
    }
}