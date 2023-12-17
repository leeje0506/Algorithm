package Coding.Codeup.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class C2062 {
//    public static int m,n;
//    public static int [][] arr;
//    public static int [] cnt; //풍선 수를 세서 저장
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //-1이면 풍선을 달 수 없음
//        // 층 > 0 인 곳들 사이마다 +1 해주자
//
//
//        //재현이는 간이 배 밖으로 나온 듯 하다.. 지붕에 풍선을 왜 다냐?
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        m = Integer.parseInt(st.nextToken());
//        n = Integer.parseInt(st.nextToken());
//
//        arr = new int [m][n];
//        cnt = new int [10];
//
//        for (int r = 0; r < m; r++) {
//            st = new StringTokenizer(br.readLine());
//            for (int c = 0; c <n; c++) {
//                arr[r][c]=Integer.parseInt(st.nextToken());
//                //각 층 풍선 세기
//                if(arr[r][c] != -1){
//                    cnt[arr[r][c]]++;
//                }
//            }
//        }
//
//        //층은 오름차순 표현
//        for (int i = 1; i < 10; i++) {
//            if(cnt[i] !=0){
//                System.out.println(i + " " + cnt[i]);
//            }
//        }
//
//    }//main
//
//}

import java.io.*;
import java.util.*;

public class C2062{
    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 델타 탐색 (상, 우, 하, 좌)
    static int[] dy = {0, 1, 0, -1};
    static int[] balloons = new int[10]; // 각 층의 풍선 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] != -1 && !visited[i][j]) {
                    int floor = map[i][j];
                    balloons[floor] = Math.max(balloons[floor], dfs(i, j, floor));
                }
            }
        }

        for(int i=0; i<10; i++) {
            if(balloons[i] != 0) {
                System.out.println(i + " " + balloons[i]);
            }
        }
    }

    // dfs를 활용한 사방 탐색
    static int dfs(int x, int y, int floor) {
        visited[x][y] = true;
        int count = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if(map[nx][ny] == floor && !visited[nx][ny]) {
                    count += dfs(nx, ny, floor);
                }
            }
        }

        return count;
    }
}
