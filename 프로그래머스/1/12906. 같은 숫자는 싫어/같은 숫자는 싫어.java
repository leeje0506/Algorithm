import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // Stack<Integer> 대신에 ArrayList<Integer>를 사용하겠습니다.
        // Stack은 후입선출(LIFO) 구조로, 여기서는 순서를 유지해야 하기 때문에 ArrayList가 적합합니다.
        ArrayList<Integer> nums = new ArrayList<>();
        
        // 배열의 첫 번째 원소를 리스트에 넣습니다.
        nums.add(arr[0]);
        
        for(int i=1; i<arr.length; i++){ // 두 번째 원소부터 비교를 시작합니다.
            if(nums.get(nums.size()-1) != arr[i]){ // 리스트의 마지막 원소와 현재 배열의 원소가 다르다면
                nums.add(arr[i]); // 현재 원소를 리스트에 추가합니다.
            }
        }

        // ArrayList를 int[]로 변환합니다.
        int[] answer = new int[nums.size()];
        for(int i=0; i<nums.size(); i++){
            answer[i] = nums.get(i);
        }

        return answer;
    }
}
