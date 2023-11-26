import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main{
    static int[] dr = {0, 0, -1, 1}; // x 좌표
    static int[] dc = {-1, 1, 0, 0}; // y 좌표
    static int[][] battle;

    static int n, m;
    static int b, w; // b 는 적군, w 는 아군의 총 전투력
    static int cnt; // 최대로 연결된 병사들의 수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //이거 반대 반대 반대로!
        battle = new int[m][n];


        //  W =1, B =2
        for(int r=0; r<m; r++){
            char[] arr = br.readLine().toCharArray();
            for (int c = 0; c < n; c++) {
                if (Objects.equals(arr[c], 'W')) {
                    battle[r][c] = 1;
                }else if(Objects.equals(arr[c], 'B')){
                    battle[r][c] = 2;
                }
            }
        }

        for(int r=0; r<m; r++){
            int result = 0;
            for(int c=0; c<n; c++){
                cnt = 1;

                if (battle[r][c] == 1) {
                    battle[r][c] = 0;  // 방문하고 0 으로 변경
                    dfs(r, c, 1);
                    result = (int) Math.pow(cnt, 2);
                    w+=result;
                } else if(battle[r][c] == 2){
                    battle[r][c] = 0;
                    dfs(r,c , 2);
                    result = (int)Math.pow(cnt, 2);
                    b+=result;
                }
            }
        }
        System.out.println(w+" "+b);



    }
    //순서 순서!!
    static void dfs(int c, int r, int num){

        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && battle[nc][nr] == num) {
                battle[nc][nr] = 0;
                cnt++;
                dfs(nc, nr, num);

            }
        }
    }
}
