import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dist = new int[100001]; // 수빈이가 해당 위치에 도달하기까지 걸린 시간을 저장하는 배열
    static int[] count = new int[100001]; // 수빈이가 해당 위치에 도달하는 방법의 수를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1); // dist 배열을 -1로 초기화

        bfs();

        System.out.println(dist[K]); // 가장 빠른 시간 출력
        System.out.println(count[K]); // 가장 빠른 시간으로 찾는 방법의 수 출력
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now - 1, now + 1, now * 2}) { // 걷거나 순간이동하는 경우
                if (next < 0 || next > 100000) continue; // 범위를 벗어나면 continue

                if (dist[next] == -1) { // 아직 방문하지 않은 경우
                    dist[next] = dist[now] + 1;
                    count[next] = count[now];
                    queue.offer(next);
                } else if (dist[next] == dist[now] + 1) { // 이미 방문했지만, 더 빠른 경로가 있는 경우
                    count[next] += count[now];
                }
            }
        }
    }
}
