import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//all: S를 {1, 2, ..., 20} 으로 바꾼다.
//empty: S를 공집합으로 바꾼다.


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());  // 연산의 수를 읽음
        int S = 0;  // 집합을 나타내는 비트 마스크, 처음엔 공집합이므로 0

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String[] line = br.readLine().split(" ");
            String command = line[0]; //명령어를 구분하기 위해 선언
            int x;

            switch (command) {
                case "add":
                    x = Integer.parseInt(line[1]) - 1; //입력된 숫자에서 1을 뺀 값 (0-based 인덱스)
                    S |= (1 << x); // x번째 비트를 1로 설정
                    break;
                case "remove":
                    x = Integer.parseInt(line[1]) - 1;
                    S &= ~(1 << x); // x번째 비트를 0으로 설정
                    break;
                case "check": // check일 때 전부 출력해줘야 함. sb에 담자
                    x = Integer.parseInt(line[1]) - 1;
                    sb.append(((S >> x) & 1) + "\n"); // x번째 비트가 1인지 확인하고 결과를 StringBuilder에 추가
                    break;
                case "toggle":
                    x = Integer.parseInt(line[1]) - 1;
                    S ^= (1 << x); // x번째 비트를 토글
                    break;
                case "all":
                    S = (1 << 20) - 1;  // 모든 20비트를 1로 설정
                    break;
                case "empty":
                    S = 0;  // 모든 비트를 0으로 설정
                    break;
            }
        }

        System.out.print(sb);
    }
}
