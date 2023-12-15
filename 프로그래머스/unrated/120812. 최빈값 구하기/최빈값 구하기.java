class Solution {
    public int solution(int[] array) {
        int answer = 0;

        // 수정: array에서 가장 큰 값을 찾아서 그 값을 기준으로 cnt 배열의 크기를 정합니다.
        int maxIdx = 0;
        for (int i = 0; i < array.length; i++) {
            maxIdx = Math.max(maxIdx, array[i]);
        }
        int[] cnt = new int[maxIdx + 1];

        // 수정: array의 각 요소 값을 인덱스로 사용하여 cnt 배열에 카운트를 누적합니다.
        for (int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
        }

        int maxCount = 0;
        int mode = 0;

        // 수정: cnt 배열의 모든 요소를 순회하면서 가장 큰 카운트 값을 찾습니다.
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] > maxCount){
                maxCount = cnt[i];
                mode = i; // 최빈값 업데이트 
            }
        }

        // 최빈값이 여러 개인지 확인합니다.
        int modeCount = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == maxCount) {
                modeCount++;
            }
        }

        // 최빈값이 여러 개면 -1을 return 합니다.
        if (modeCount > 1) {
            return -1;
        }

        answer = mode; // 최빈값을 반환합니다.
        return answer;
    }
}
