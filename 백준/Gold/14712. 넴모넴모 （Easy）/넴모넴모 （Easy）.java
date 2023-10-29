

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer, cnt;
    static int [][] map;
//    static int[] dr = {0, -1, -1};
//    static int[] dc = {-1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        //여기 +1 해줘야 된다.. 안하면 틀림.. 알고 싶지 않았음
        map = new int[N+1][M+1];
        cnt =0;

        dfs(0);
        System.out.println(answer);
    }//main

    public static void dfs (int cnt){
        if(cnt == N*M){
            answer = answer + 1;
            return;
        }
        int r = cnt / M+1;
        int c = cnt % M+1;

        //현재 놓을 수 없는 경우
        if(map[r-1][c] == 1 && map[r][c-1]==1 && map[r-1][c-1]==1){
            dfs(cnt +1);
        }
        //놓을 수 있고,
        else{
            //선택 안함, 다음
            dfs(cnt+1);
            map[r][c] =1;
            //선택 함, 다음
            dfs(cnt+1);
            map[r][c]=0;
        }


    }
}
