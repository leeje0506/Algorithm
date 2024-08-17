class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        //장군 5, 병정 3, 일 1
        answer +=(hp/5);
        answer +=((hp%5)/3);
        answer +=((hp%5)%3);
        
        return answer;
    }
}