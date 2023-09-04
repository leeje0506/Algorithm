class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken >= 10) {
            //서비스치킨
            answer += chicken / 10;
            //..
            chicken = (chicken / 10) + (chicken % 10);
        }
        return answer;
    }
}