package Coding.Codeup.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2605 {
    public static int[][] board;
    public static int[] dr = {-1, 0, 1, 0}; // 델타 탐색 (상, 우, 하, 좌)
    public static int[] dc = {0, 1, 0, -1};
    public static boolean[][] visited;
    public static int answer, cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        board = new int [7][7];
        visited = new boolean[7][7];

        for (int r = 0; r < 7; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 7; c++) {
                board[r][c]=Integer.parseInt(st.nextToken());
            }
        }// 입력 끝

        answer = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c <7; c++) {
                if(visited[r][c] ==false){
                    cnt=0;
                    //각 셀에 대한 모든 탐색을 진행하기 때문에
                    //모든 색상에 대한 연속된 영역을 찾을 수 있다.
                    dfs(r,c,board[r][c]);
                    if(cnt >=3) answer++;
                }
            }
        }

        System.out.println(answer);

    }//main

    public static void dfs(int x, int y, int color){

        //방문 쳌
        visited[x][y] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = x + dr[d];
            int nc = y + dc[d];
            if(nr>=0 && nr<7 && nc>=0 && nc<7){
                //컬러 이면서, 방문하지 않은 칸에 대해서 dfs 실행
                if(board[nr][nc]==color && visited[nr][nc]==false){
                    dfs(nr, nc, color);
                }

            }
        }

    }//dfs
}
