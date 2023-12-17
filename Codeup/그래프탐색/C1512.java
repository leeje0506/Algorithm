package Coding.Codeup.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
//public class C1512 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        int X = Integer.parseInt(st.nextToken())-1;
//        int Y = Integer.parseInt(st.nextToken())-1;
//
//        int[][] arr = new int[N][N];
//        boolean[][] visited = new boolean[N][N];  // 방문 여부를 체크할 배열입니다.
//        Queue<int[]> queue = new LinkedList<>();  // BFS를 위한 큐입니다.
//
//        arr[X][Y] = 1;  // 시작 위치의 숫자 등고선 값은 1입니다.
//        visited[X][Y] = true;  // 시작 위치를 방문했다고 표시합니다.
//        queue.offer(new int[]{X, Y});  // 시작 위치를 큐에 넣습니다.
//
//        int[] dx = {-1, 0, 1, 0};  // 상하좌우 이동을 위한 x좌표 변화량입니다.
//        int[] dy = {0, 1, 0, -1};  // 상하좌우 이동을 위한 y좌표 변화량입니다.
//
//        // BFS를 시작합니다.
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();  // 현재 위치를 큐에서 꺼냅니다.
//
//            for (int i = 0; i < 4; i++) {
//                int nx = current[0] + dx[i];  // 다음 위치의 x좌표를 계산합니다.
//                int ny = current[1] + dy[i];  // 다음 위치의 y좌표를 계산합니다.
//
//                // 다음 위치가 배열 범위 내에 있고 아직 방문하지 않았다면
//                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
//                    arr[nx][ny] = arr[current[0]][current[1]] + 1;  // 다음 위치의 숫자 등고선 값은 현재 위치의 값 + 1입니다.
//                    visited[nx][ny] = true;  // 다음 위치를 방문했다고 표시합니다.
//                    queue.offer(new int[]{nx, ny});  // 다음 위치를 큐에 넣습니다.
//                }
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}


//dfs
public class C1512 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};  // 상하좌우 이동을 위한 x좌표 변화량입니다.
    static int[] dy = {0, 1, 0, -1};  // 상하좌우 이동을 위한 y좌표 변화량입니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken())-1;
        int Y = Integer.parseInt(st.nextToken())-1;

        arr = new int[N][N];
        visited = new boolean[N][N];  // 방문 여부를 체크할 배열입니다.

        arr[X][Y] = 1;  // 시작 위치의 숫자 등고선 값은 1입니다.
        dfs(X, Y);  // DFS를 시작합니다.

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;  // 현재 위치를 방문했다고 표시합니다.

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];  // 다음 위치의 x좌표를 계산합니다.
            int ny = y + dy[i];  // 다음 위치의 y좌표를 계산합니다.

            // 다음 위치가 배열 범위 내에 있고 아직 방문하지 않았거나, 다음 위치의 숫자 등고선 값이 현재 위치의 값 + 1보다 크다면
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && (!visited[nx][ny] || arr[nx][ny] > arr[x][y] + 1)) {
                arr[nx][ny] = arr[x][y] + 1;  // 다음 위치의 숫자 등고선 값은 현재 위치의 값 + 1입니다.
                dfs(nx, ny);  // 다음 위치에서 DFS를 계속합니다.
            }
        }
    }
}