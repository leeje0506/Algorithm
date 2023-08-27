import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 0; tc < 4; tc++) {  // 테스트 케이스 수는 4개이므로 tc=0부터 시작
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();

            // 두 직사각형의 위치 관계를 판단하여 출력
            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                System.out.println("d");  // 겹치지 않는 경우
            } else if ((p1 == x2 || p2 == x1) && (q1 == y2 || q2 == y1)) {
                System.out.println("c");  // 꼭지점에서 만나는 경우
            } else if (p1 == x2 || p2 == x1 || q1 == y2 || q2 == y1) {
                System.out.println("b");  // 선분으로 만나는 경우
            } else {
                System.out.println("a");  // 겹치는 경우
            }
        } // for문
    } // main
} // class
