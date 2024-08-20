class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        // 각 차원의 길이를 n으로 나눈 몫을 구한 후, 이를 곱하여 가능한 큐브의 개수를 구함
        int lengthCount = box[0] / n;
        int widthCount = box[1] / n;
        int heightCount = box[2] / n;
        
        // 총 가능한 큐브 수 계산
        answer = lengthCount * widthCount * heightCount;

        return answer;
    }
}