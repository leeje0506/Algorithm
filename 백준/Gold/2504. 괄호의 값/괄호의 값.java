import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    static String input;  // 입력받은 괄호 문자열을 저장하는 변수
    static int[] pair;    // 괄호 쌍의 위치를 저장하는 배열

    // 재귀 함수로 괄호 쌍 별로 계산하는 함수
    public static int recur(int start, int end) {
        // 괄호 쌍이 하나만 있는 경우
        if (end - start == 1) {
            // 괄호가 '(' 이면 2를 반환
            if (input.charAt(start) == '(') return 2;
            // 괄호가 '[' 이면 3을 반환
            else return 3;
        }

        // 괄호가 '(' 이면 곱셈 값으로 2를, 아니면 3을 설정
        int mul = input.charAt(start) == '(' ? 2 : 3;
        start++;

        // 괄호 쌍 내부의 값을 합산
        int sum = 0;
        while (start <= end - 1) {
            int pairIdx = pair[start];
            sum += recur(start, pairIdx);
            start = pairIdx + 1;
        }

        // 내부의 합산 값에 외부 괄호 값 곱하기
        return sum * mul;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 괄호 문자열의 올바름 여부를 판단하는 변수
        boolean incorrect = false;  

        input = sc.next();

        // 괄호의 올바름 여부를 확인하는 스택
        Stack<Character> validCheck = new Stack<>();
        // 괄호의 인덱스를 저장하는 스택
        Stack<Integer> stack = new Stack<>();

        pair = new int[input.length()];

        // 입력받은 문자열을 순회하며 괄호의 짝을 찾음
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                validCheck.add(')');
                stack.add(i);
            } else if (c == '[') {
                validCheck.add(']');
                stack.add(i);
            } else {
                // 스택이 비어있는데 pop을 시도하는 경우를 방지
                if(validCheck.isEmpty()) { 
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

        // 괄호 문자열이 올바르지 않은 경우 0 출력
        if (!validCheck.isEmpty() || incorrect) {
            System.out.println(0);
        } else {
            // 올바른 괄호 문자열인 경우 각 괄호 쌍 별로 계산
            int sum = 0;
            int start = 0;
            int end = input.length() - 1;
            
            while (start <= end) {
                int pairIdx = pair[start];
                int tmp = recur(start, pairIdx);
                sum += tmp;
                start = pairIdx + 1;
            }
            
            // 최종 결과 출력
            System.out.println(sum);
        }
    }
}
