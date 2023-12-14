import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            // stk이 비어있지 않고, stk의 마지막 원소가 arr[i]보다 크거나 같은 동안 stk의 원소를 제거
            while (!stk.isEmpty() && stk.peek() >= arr[i]) {
                stk.pop();
            }

            // arr[i]를 stk에 추가
            stk.push(arr[i]);
        }

        // stk의 원소를 배열로 변환하여 반환
        int[] answer = new int[stk.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = stk.get(i);
        }
        return answer;
    }
}
