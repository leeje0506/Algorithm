import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] iceberg;
    static int[][] temp;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        iceberg = new int[N][M];
        temp = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int year = 0;
        while (true) {
            int count = 0;
            visited = new boolean[N][M];
            
            // 빙산 덩어리 개수 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (iceberg[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            
            if (count == 0) {
                // 모두 녹을 때까지 분리되지 않음
                System.out.println(0);
                break;
            } else if (count >= 2) {
                // 빙산이 두 덩어리 이상으로 분리됨
                System.out.println(year);
                break;
            }
            
            year++;
            melt();
        }
    }
    
    // 빙산 덩어리 개수 확인을 위한 DFS
    static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (iceberg[nx][ny] > 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
    
    // 빙산 녹이기
    static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0) {
                    int count = 0;
                    
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (iceberg[nx][ny] == 0) {
                                count++;
                            }
                        }
                    }
                    
                    temp[i][j] = Math.max(0, iceberg[i][j] - count);
                }
            }
        }
        
        iceberg = temp.clone();
        temp = new int[N][M];
    }
}
