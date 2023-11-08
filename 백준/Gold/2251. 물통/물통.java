
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int numA, numB, numC;
    static boolean [][] visited;
    static Queue<int[]> que;
    static LinkedList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        que = new LinkedList<int[]>();
        visited = new boolean[201][201];
        answer = new LinkedList<Integer>();

        numA = Integer.parseInt(st.nextToken());
        numB = Integer.parseInt(st.nextToken());
        numC = Integer.parseInt(st.nextToken());

        //시작점
        int start[] = {0,0};
        que.add(start);

        //큐가 빌 때까지
        while(!que.isEmpty()){
            //
            int a = que.peek()[0];
            int b = que.peek()[1];
            int c = numC - a - b;
            que.poll();

            //들렀던 물통은 컨티뉴
            if(visited[a][b])
                continue;

            if (a == 0)
                answer.add(c);

            visited[a][b] = true;
            if (a + b <= numB) {
                que.add(new int[] { 0, a + b });
            } else {
                que.add(new int[] { a + b - numB, numB });
            }
            if (a + c <= numC) {
                que.add(new int[] { 0, b });
            } else {
                que.add(new int[] { a + c - numC, b });
            }
            if (b + a <= numA) {
                que.add(new int[] { a + b, 0 });
            } else {
                que.add(new int[] { numA, b + a - numA });
            }
            if (b + c <= numC) {
                que.add(new int[] { a, 0 });
            } else {
                que.add(new int[] { a, b + c - numC });
            }
            if (c + a <= numA) {
                que.add(new int[] { a + c, b });
            } else {
                que.add(new int[] { numA, b });
            }
            if (c + b <= numB) {
                que.add(new int[] { a, b + c });
            } else {
                que.add(new int[] { a, numB });
            }
        }
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i)+" ");

        }

    }//main
}
