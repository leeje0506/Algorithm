import java.io.*;
import java.util.*;

public class Main {

    static class Info {
        int strike, ball;
        int num;
        
        public Info(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static int N, strike, ball, num;
    static ArrayList<Info> baseballGame = new ArrayList<>();
    static ArrayList<String> answer = new ArrayList<>();  
    static boolean[] pickNumber;     

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        pickNumber = new boolean[10];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            num = Integer.parseInt(st.nextToken());
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());
            baseballGame.add(new Info(num, strike, ball));
        }
        search("", 0);
        System.out.println(answer.size() + "");
    }

    // 모든 경우의 수 탐색
    static void search(String num, int size) {
        // 3개 뽑았을 때, 조건 확인
        if (size == 3) {
            numCheck(num);
            return;
        }
        // 1~9까지 숫자 중에 뽑기 가능
        for (int i = 1; i <= 9; i++) {
            if (!pickNumber[i]) {
                pickNumber[i] = true;
                search(num + i, size + 1);
                pickNumber[i] = false;
            }
        }
    }

    // 조건 확인
    static void numCheck(String num) {
        for (Info cur : baseballGame) {
            int strike = 0;
            int ball = 0;

            // 스트라이크 및 볼 조건 확인
            for (int i = 0; i < 3; i++) {
                char curDigit = String.valueOf(cur.num).charAt(i);
                char guessDigit = num.charAt(i);

                if (curDigit == guessDigit) {
                    strike++;
                } else if (num.contains(String.valueOf(curDigit))) {
                    ball++;
                }
            }

            if (cur.strike != strike || cur.ball != ball) {
                return;
            }
        }
        // 모든 조건을 만족할 때 추가
        answer.add(num);
    }
}
