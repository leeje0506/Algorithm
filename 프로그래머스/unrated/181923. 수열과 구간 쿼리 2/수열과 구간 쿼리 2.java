class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE; // 수정: 최소값을 추적하기 위한 변수 min을 Integer.MAX_VALUE로 초기화
            boolean found = false; // 수정: queries[i][2]보다 큰 값이 있는지 여부를 확인하기 위한 변수 found 추가
            
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) {
                    min = Math.min(arr[j], min); // 수정: 현재까지의 최소값을 업데이트
                    found = true; // 수정: queries[i][2]보다 큰 값이 존재함을 표시
                }
            }
            
            if (found) {
                answer[i] = min;
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}
