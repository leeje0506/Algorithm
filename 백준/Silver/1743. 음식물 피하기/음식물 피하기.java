import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우로 이동하기 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 통로를 표현할 2차원 배열
        boolean[][] map = new boolean[N][M];
        // 방문 여부를 표시할 2차원 배열
        boolean[][] visited = new boolean[N][M];

        // 음식물이 떨어진 좌표를 map에 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }

        int max = 0; // 가장 큰 음식물의 크기를 저장할 변수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 음식물이 떨어진 곳이면서, 아직 방문하지 않은 경우
                if (map[i][j] && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j, map, visited));
                }
            }
        }

        System.out.println(max);
    }

    // BFS를 수행하는 메소드
    public static int bfs(int x, int y, boolean[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 범위를 벗어나거나, 음식물이 없거나, 이미 방문한 경우는 제외
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || !map[nx][ny] || visited[nx][ny]) {
                    continue;
                }

                queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                count++;
            }
        }

        return count;
    }
}
