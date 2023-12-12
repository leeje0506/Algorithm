class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        
        int len = myString.length();
        int patLen = pat.length();

        //뒤에서부터 비교.
        for (int i = len - patLen; i >= 0; i--) {
            if(myString.substring(i, i + patLen).equals(pat)){
                //부분 문자열 끝 인덱스부터 그 이전 문자열 반환
                return myString.substring(0, i + patLen);
            }
        }
        return answer;
    }
}