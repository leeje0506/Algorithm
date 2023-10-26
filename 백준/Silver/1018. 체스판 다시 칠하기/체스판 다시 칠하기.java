import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                if (str.charAt(c) == 'W') {
                    board[r][c] = "W";
                } else {
                    board[r][c] = "B";
                }
            }
        }

        int min = 64;

        for (int r = 0; r < N - 7; r++) { // 세로의 경우의 수
            for (int c = 0; c < M - 7; c++) { // 가로의 경우의 수
                min = Math.min(min, cal(r, c)); // 최소값을 저장
            }
        }

        System.out.println(min);

        br.close();
    }

    public static int cal(int x, int y) {

        int cnt = 0;

        // 첫번째 칸이 W이라고 가정하고 색칠
        String color = "W";

        // 시작부터 8개까지
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (!board[i][j].equals(color)) {
                    cnt++;
                }
                // 컬러 변경
                if (color.equals("W")) {
                    color = "B";
                } else {
                    color = "W";
                }
            }

            // 줄이 바뀌면 윗칸과 색이 다름
            if (color.equals("W")) {
                color = "B";
            } else {
                color = "W";
            }
        }

        cnt = Math.min(cnt, 64 - cnt);

        return cnt;
    }
}
