import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int MAX = 100000; // 수빈이와 동생의 위치 범위 (0 ≤ N, K ≤ 100,000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        if (N >= K) {
            System.out.println(N - K); // 수빈이가 동생보다 앞에 있거나 같은 위치에 있을 경우
        } else {
            System.out.println(bfs(N, K)); // BFS를 이용해 최소 시간 계산
        }
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[MAX + 1]; // 방문 여부 및 시간을 저장할 배열
        Arrays.fill(visited, -1); // 초기값은 -1로 설정

        queue.offer(start);
        visited[start] = 0; // 시작 위치는 0초로 설정

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 순간이동
            int teleport = current * 2;
            if (teleport <= MAX && visited[teleport] == -1) {
                visited[teleport] = visited[current]; // 순간이동은 시간이 걸리지 않으므로 현재 시간 그대로
                queue.offer(teleport);
            }

            // 걷기: 현재 위치에서 -1
            int back = current - 1;
            if (back >= 0 && visited[back] == -1) {
                visited[back] = visited[current] + 1; // 걷기는 1초 후에 이동하므로 시간 +1
                queue.offer(back);
            }

            // 걷기: 현재 위치에서 +1
            int forward = current + 1;
            if (forward <= MAX && visited[forward] == -1) {
                visited[forward] = visited[current] + 1; // 걷기는 1초 후에 이동하므로 시간 +1
                queue.offer(forward);
            }
        }

        return visited[end]; // 동생을 찾는 데 걸린 최소 시간 반환
    }
}
