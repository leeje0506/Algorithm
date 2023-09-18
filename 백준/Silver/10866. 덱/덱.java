

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static Deque<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령의 수

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= N; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                que.offerFirst(x);               
            } 
            else if (s.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                que.offerLast(x);               
            } 
            else if (s.equals("pop_front")) {
                if (que.size() < 1) { // 큐가 비어있을 때
                    sb.append(-1).append("\n"); // -1을 추가하고 줄바꿈
                } else {
                    sb.append(que.pollFirst()).append("\n"); // 큐에서 값을 꺼내고 추가하고 줄바꿈
                }
            } 
            else if (s.equals("pop_back")) {
                if (que.size() < 1) { // 큐가 비어있을 때
                    sb.append(-1).append("\n"); // -1을 추가하고 줄바꿈
                } else {
                    sb.append(que.pollLast()).append("\n"); // 큐에서 값을 꺼내고 추가하고 줄바꿈
                }
            }
            else if (s.equals("size")) {
                sb.append(que.size()).append("\n"); // 큐의 크기를 추가하고 줄바꿈
            } else if (s.equals("empty")) {
                if (que.isEmpty()) {
                    sb.append(1).append("\n"); // 큐가 비어있으면 1을 추가하고 줄바꿈
                } else {
                    sb.append(0).append("\n"); // 큐가 비어있지 않으면 0을 추가하고 줄바꿈
                }
            } else if (s.equals("front")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n"); // 큐가 비어있을 때 -1을 추가하고 줄바꿈
                } else {
                    sb.append(que.peekFirst()).append("\n"); // 큐의 맨 앞 값을 추가하고 줄바꿈
                }
            } else if (s.equals("back")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n"); // 큐가 비어있을 때 -1을 추가하고 줄바꿈
                } else {
                    sb.append(que.peekLast()).append("\n"); // 큐의 맨 뒤 값을 추가하고 줄바꿈
                }
            }
        } // tc for문

        System.out.println(sb.toString()); // 결과를 출력
    }
}
