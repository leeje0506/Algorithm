import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 삭제할 요소를 체크할 배열을 초기화합니다.
        boolean[] toDelete = new boolean[arr.length];
        
        // 삭제할 요소를 체크합니다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    toDelete[i] = true;
                    break;
                }
            }
        }
        
        // 삭제하지 않을 요소만 리스트에 추가합니다.
        for (int i = 0; i < arr.length; i++) {
            if (!toDelete[i]) {
                list.add(arr[i]);
            }
        }
        
        // ArrayList를 Integer 배열로 변환합니다.
        Integer[] arr2 = list.toArray(new Integer[0]);
        
        int[] answer = new int[arr2.length];
        
        for (int i = 0; i < arr2.length; i++) {
            answer[i] = arr2[i];
        }
        return answer;
    }
}
