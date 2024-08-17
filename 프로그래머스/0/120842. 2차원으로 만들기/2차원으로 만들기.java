class Solution {
    public int[][] solution(int[] num_list, int n) {
        // 2차원 배열의 행의 수는 num_list 길이를 n으로 나눈 값
        int rowCount = num_list.length / n;
        // 2차원 배열 선언
        int[][] answer = new int[rowCount][n];
        
        // num_list의 값을 순서대로 2차원 배열에 채워 넣기
        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        
        return answer;
    }
}
