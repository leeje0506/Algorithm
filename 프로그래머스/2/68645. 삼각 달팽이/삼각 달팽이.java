class Solution {
    public int[] solution(int n) {
        // 삼각형 배열을 생성하고 초기화합니다.
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }
        
        // 델타 값(방향 변화량)을 정의합니다. (아래, 오른쪽, 왼쪽 위)
        int[] dr = {1, 0, -1}; // 행의 변화량
        int[] dc = {0, 1, -1}; // 열의 변화량
        
        int row = 0, col = 0; // 현재 위치
        int dir = 0; // 현재 방향
        int value = 1; // 채워넣을 값
        
        while (value <= n * (n + 1) / 2) {
            // 현재 위치에 값을 채워넣고, value를 증가시킵니다.
            triangle[row][col] = value++;
            
            // 다음 위치를 계산합니다.
            int nextRow = row + dr[dir];
            int nextCol = col + dc[dir];
            
            // 다음 위치가 삼각형 배열의 범위를 벗어나거나 이미 채워진 칸인지 확인합니다.
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol > nextRow || triangle[nextRow][nextCol] != 0) {
                // 방향을 변경합니다. (아래 -> 오른쪽 -> 왼쪽 위 -> 아래 ...)
                dir = (dir + 1) % 3;
                nextRow = row + dr[dir];
                nextCol = col + dc[dir];
            }
            
            // 위치를 업데이트합니다.
            row = nextRow;
            col = nextCol;
        }
        
        // 2차원 배열의 값을 1차원 배열로 변환합니다.
        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}
