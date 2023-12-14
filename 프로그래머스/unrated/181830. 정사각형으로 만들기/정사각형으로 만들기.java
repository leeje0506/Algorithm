class Solution {
        public int[][] solution(int[][] arr) {
            int max = Math.max(arr.length, arr[0].length); // 행과 열 중 더 긴 길이를 찾음
            int[][] answer = new int[max][max]; // 그 길이를 기반으로 answer 배열 초기화

            for (int r = 0; r < max; r++) {
                for (int c = 0; c < max; c++) {
                    // arr의 범위를 벗어나는 경우 0을 추가
                    if (r >= arr.length || c >= arr[0].length) {
                        answer[r][c] = 0;
                    } else { // 범위 내에 있는 경우 원래 값 복사
                        answer[r][c] = arr[r][c];
                    }
                }
            }
        return answer;
    }
}