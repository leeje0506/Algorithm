import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> expList; // 수식을 담을 리스트
    static List<String[]> allPriority = new ArrayList<>(); // 모든 우선순위 조합을 담을 리스트
    static String[] operators = {"+", "-", "*"}; // 연산자 집합

    public long solution(String expression) {
        expList = new ArrayList<>();
        String num = "";
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                expList.add(num);
                num = ""; // 숫자 초기화
                expList.add(ch + ""); // 연산자 추가
            } else {
                num += ch; // 숫자 문자열 누적
            }
        }
        expList.add(num); // 마지막 숫자 추가

        // 연산자 우선순위 조합 생성
        permute(operators, 0);

        long answer = 0; // 최대 결과값 초기화
        // 각 우선순위에 따른 계산 실행
        for (String[] priority : allPriority) {
            long result = compute(new ArrayList<>(expList), priority);
            answer = Math.max(answer, result); // 최대값 갱신
        }

        return answer;
    }

    // 모든 조합의 경우(순열) 생성
    public void permute(String[] arr, int idx) {
        if (idx == arr.length) {
            allPriority.add(arr.clone());
        } else {
            for (int i = idx; i < arr.length; i++) {
                swap(arr, i, idx); // 현재 요소와 idx 요소 교환
                permute(arr, idx + 1); // 다음 요소를 위한 순열 생성
                swap(arr, idx, i); // 원래 상태로 배열 복구
            }
        }
    }

    // 배열 요소 swap
    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 수식 계산 (우선순위에 따라) 및 계산 결과 반환
    static long compute(List<String> expression, String[] priority) {
        for (String op : priority) {
            while (expression.contains(op)) {
                int opIdx = expression.indexOf(op);
                long result = calculate(Long.parseLong(expression.get(opIdx - 1)), Long.parseLong(expression.get(opIdx + 1)), op);
                expression.subList(opIdx - 1, opIdx + 2).clear(); // 계산에 사용된 숫자와 연산자 제거
                expression.add(opIdx - 1, String.valueOf(result)); // 계산 결과 삽입
            }
        }
        return Math.abs(Long.parseLong(expression.get(0))); // 최종 계산 결과의 절대값 반환
    }

    // 계산 실행
    static long calculate(long a, long b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new IllegalArgumentException("알 수 없는 연산자: " + op);
        }
    }
}
