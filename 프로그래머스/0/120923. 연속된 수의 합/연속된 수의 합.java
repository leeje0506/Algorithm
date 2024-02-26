public class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        // 첫 번째 수를 찾기 위해 중간값을 이용.
        // 연속된 수들의 평균은 total / num이며, 여기서부터 양쪽으로 확장
        int firstNum = (total/num)-(num-1)/2;
        // 첫 번째 수부터 시작하여 연속된 num개의 정수를 배열에 저장
        for(int i=0; i<num; i++){
            answer[i] = firstNum + i;
        }
        return answer;
    }
}