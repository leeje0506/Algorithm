import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
		//고슴도치 이동을 저장할 큐
    public static Queue<int[]> q = new LinkedList<>();;
		//물의 확장을 저장할 큐
    public static Queue<int[]> water = new LinkedList<>();;
    public static int r, c;
    public static Character[][] map;
    public static int[][] count;
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new Character[r][c];
        count = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
								//S : 고슴도치 위치
                if (map[i][j]=='S') {
                    q.add(new int[]{i, j,0});
								//* : 물이 차있는 위치
                }else if(map[i][j]=='*'){
                    water.add(new int[]{i,j});
                }
            }
        }


        bfs();
				//안전하게 이동할 수 없다면 "KAKTUS", 아니면 answer 출력
        System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);


    }

    public static void bfs() {

				//고슴도치의 큐가 비어있지 않으면 계속 실행됨.
        while (!q.isEmpty()) {
            // 물 퍼뜨림
            int len = water.size();
            for(int i=0;i<len;i++){
                int[] t = water.poll();
                int x = t[0];
                int y = t[1];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny]=='.') {
                        map[nx][ny] = '*';
                        water.add(new int[]{nx,ny});
                    }
                }
            }

            // 고슴도치 이동
            len = q.size();
            for(int i=0;i<len;i++){
                int[] t = q.poll();
                int x = t[0];
                int y = t[1];
                int time = t[2];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
												//D : 비버의 굴
                        if(map[nx][ny]=='D'){
                            answer=Math.min(answer,time+1);
                            return;
												//. : 비어있는 곳
                        }else if(map[nx][ny]=='.'){
                            map[nx][ny] = 'S';
                            q.add(new int[]{nx,ny,time+1});
                        }
                    }
                }
            }
        }
    }
}