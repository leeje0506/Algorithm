import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;

class Lecture implements Comparable<Lecture> {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N]; 
        
        // 수업 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }
        
        // 수업 시작 시간 기준 정렬
        Arrays.sort(lectures);
        
        // 우선순위 큐 - 강의실 종료 시간 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (Lecture lecture : lectures) {
            // 현재 강의 시작 전에 끝나는 강의실 있으면 업데이트
            if (!pq.isEmpty() && pq.peek() <= lecture.start) {
                pq.poll();
            }
            pq.offer(lecture.end); // 현재 강의 종료 시간 추가
        }
        
        // 필요한 강의실 개수 출력
        System.out.println(pq.size());
    }
}
