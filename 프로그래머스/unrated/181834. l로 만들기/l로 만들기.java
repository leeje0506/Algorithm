class Solution {
    public String solution(String myString) {
        //a-I까지는 전부 I로 바꾸기
        String answer = myString.replaceAll("[a-l]", "l");
        return answer;
    }
}