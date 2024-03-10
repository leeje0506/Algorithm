import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int R, C, maxCount;
    static char[][] board;
    static boolean[] visited = new boolean[26]; 
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 
    static int[] dy = {0, 0, -1, 1}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        maxCount = 0;
        dfs(0, 0, 1); // 시작 칸을 포함-> 1로 시작

        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int count) {
        if (x < 0 || y < 0 || x >= R || y >= C || visited[board[x][y] - 'A']) {
            return;
        }

        visited[board[x][y] - 'A'] = true;
        maxCount = Math.max(maxCount, count); // 현재 경로의 칸 수로 최대 칸 수 갱신
        
        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, count + 1);
        }
        visited[board[x][y] - 'A'] = false; // 현재 경로 탐색 후 방문 처리 해제
    }
}
