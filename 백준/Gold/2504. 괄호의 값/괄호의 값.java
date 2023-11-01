import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
    static String input;  // 입력받은 괄호 문자열을 저장하는 변수
    static int[] pair;    // 괄호 쌍의 위치를 저장하는 배열

    // 재귀 함수로 괄호 쌍 별로 계산하는 함수
    public static int recur(int start, int end) {
        if (end - start == 1) {  // 괄호 쌍이 하나만 있는 경우
            if (input.charAt(start) == '(') return 2;  // '(' 이면 2 반환
            else return 3;  // '[' 이면 3 반환
        }

        int mul = input.charAt(start) == '(' ? 2 : 3;  // '(' 이면 2, 아니면 3
        start++;

        int sum = 0;  // 괄호 쌍 내부의 값을 합산하는 변수
        while (start <= end - 1) {
            int pairIdx = pair[start];
            sum += recur(start, pairIdx);
            start = pairIdx + 1;
        }

        return sum * mul;  // 내부의 합산 값에 외부 괄호 값 곱하기
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean incorrect = false;  // 괄호 문자열의 올바름 여부를 판단하는 변수

        input = br.readLine();

        Stack<Character> validCheck = new Stack<>();  // 괄호의 올바름 여부를 확인하는 스택
        Stack<Integer> stack = new Stack<>();  // 괄호의 인덱스를 저장하는 스택

        pair = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                validCheck.add(')');
                stack.add(i);
            } else if (c == '[') {
                validCheck.add(']');
                stack.add(i);
            } else {
                if(validCheck.isEmpty()) {  // 스택이 비어있는데 pop을 시도하는 경우를 방지
                    incorrect = true;
                    break;
                }
                char popChar = validCheck.pop();
                if (c != popChar) {
                    incorrect = true;
                    break;
                }
                int popIdx = stack.pop();
                pair[popIdx] = i;
                pair[i] = popIdx;
            }
        }

        if (!validCheck.isEmpty() || incorrect) {
            System.out.println(0);  // 괄호 문자열이 올바르지 않은 경우 0 출력
        } else {
            int sum = 0; 
            int start = 0;
            int end = input.length() - 1;
            
            while (start <= end) {
                int pairIdx = pair[start];
                int tmp = recur(start, pairIdx);
                sum += tmp;
                start = pairIdx + 1;
            }
            
            System.out.println(sum);  // 최종 결과 출력
        }
    }
}