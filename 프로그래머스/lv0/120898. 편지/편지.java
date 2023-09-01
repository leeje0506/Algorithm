class Solution {
    public int solution(String message) {
        int answer = 0;
        int cnt=0;
        
        for(int i=0; i<message.length(); i++){
            answer = cnt++;
        }
        answer = cnt*2;
        return answer;
    }
}