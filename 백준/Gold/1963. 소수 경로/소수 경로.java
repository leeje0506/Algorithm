import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime = new boolean[10000]; // 소수를 판별할 배열
    static boolean[] check; // 방문 여부를 체크할 배열
    static int[] distance; // 최소 회수를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        getPrime(); // 소수를 판별하는 함수 호출

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            check = new boolean[10000];
            distance = new int[10000];

            bfs(A, B); // bfs 호출

            if (check[B]) { // B를 방문했다면 distance[B] 출력
                System.out.println(distance[B]);
            } else { // B를 방문하지 않았다면 Impossible 출력
                System.out.println("Impossible");
            }
        }
    }

    static void getPrime() { // 소수를 판별하는 함수
        for (int i = 2; i < Math.sqrt(10000); i++) {
            if (!prime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = true; // 소수가 아니면 true로 표시
                }
            }
        }
    }

    static void bfs(int A, int B) { // bfs 함수
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        check[A] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    int next = change(now, i, j); // 숫자를 변경하는 함수 호출
                    if (next != -1 && !prime[next] && !check[next]) { // next가 -1이 아니고, 소수이며, 아직 방문하지 않았다면
                        queue.offer(next);
                        check[next] = true;
                        distance[next] = distance[now] + 1; // 현재까지의 거리에 1을 더함
                    }
                }
            }
        }
    }

    static int change(int num, int i, int j) { // 숫자를 변경하는 함수
        if (i == 0 && j == 0) return -1; // 첫 번째 자리를 0으로 바꿀 수 없음

        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char)(j + '0'));
        return Integer.parseInt(sb.toString());
    }
}
