import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        dist = new int[N + 1];
        Arrays.fill(dist, (int) 1e9);

        BFS(X);

        boolean check = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if (dist[nextNode] == (int) 1e9) {
                    dist[nextNode] = dist[now] + 1;
                    q.offer(nextNode);
                }
            }
        }
    }
}
