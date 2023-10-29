

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, next;
    static int answer = Integer.MAX_VALUE;
    static int [][] map;
    static int [] dr = {1,1,1};
    static int [] dc = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }//입력 끝

        for(int c=0; c<M; c++){
            next =0;
            next += map[0][c];
            dfs(0, c, next, 3);
        }
        System.out.println(answer);
    }//main


    public static void dfs(int r, int c, int next, int dir){
        if(r==N-1){
            if(next < answer) answer = next;
            return;
        }

        for(int d=0; d<3; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr>=0&& nc>=0 && nr<N && nc<M){
                //최근에 움직인 방향이 아니면 재귀 호출
                if(dir != d){
                    dfs(nr,nc,next+map[nr][nc], d);
                }
            }
        }
    }//dfs
}//class
