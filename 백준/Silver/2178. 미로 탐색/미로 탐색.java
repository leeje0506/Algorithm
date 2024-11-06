import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static int[][] distance;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 방향
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기
        
        maze = new int[n][m];
        distance = new int[n][m]; // 각 칸까지의 최소 거리 저장
        
        // 미로 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0)); // (0, 0)에서 BFS 시작
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        distance[x][y] = 1; // 시작 위치의 칸 수는 1로 설정

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 미로 범위 내에 있으며, 이동할 수 있는 칸이고, 방문하지 않은 칸이면
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && distance[nx][ny] == 0) {
                    distance[nx][ny] = distance[curX][curY] + 1; // 거리 갱신
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        // 목적지 (n-1, m-1)까지의 거리 반환
        return distance[n-1][m-1];
    }
}
