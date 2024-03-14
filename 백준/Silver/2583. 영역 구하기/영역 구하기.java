

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 이동을 위한 배열
    static int[] dy = {1, -1, 0, 0}; // 상하좌우 이동을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        board = new int[m][n];
        visited = new boolean[m][n];
        
        // 직사각형을 모눈종이에 그리기
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 모눈종이에 직사각형 그리기
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    areas.add(bfs(i, j)); // BFS로 영역의 크기 계산
                }
            }
        }
        
        Collections.sort(areas); // 영역의 넓이 오름차순 정렬
        System.out.println(areas.size()); // 분리된 영역의 개수 출력
        for (int area : areas) {
            System.out.print(area + " "); // 각 영역의 넓이 출력
        }
    }

    // BFS로 영역 탐색
    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            area++;
            
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                // 범위 체크 및 방문 체크
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return area; // 탐색한 영역의 크기 반환
    }
}
