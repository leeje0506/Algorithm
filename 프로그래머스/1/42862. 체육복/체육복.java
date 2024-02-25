public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생들의 체육복 수를 나타내는 배열 초기화
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = 1; // 모든 학생이 최소 하나의 체육복을 가지고 있음
        }
        
        // 도난당한 학생 처리
        for (int l : lost) {
            students[l - 1]--; // 체육복을 하나 잃어버림
        }
        
        // 여벌 체육복을 가진 학생 처리
        for (int r : reserve) {
            students[r - 1]++; // 여벌 체육복이 있으면 하나 더함
        }
        
        // 체육복 빌려주기
        for (int i = 0; i < n; i++) {
            // 체육복이 없는 학생에게 여벌이 있는 학생이 체육복 빌려줌
            if (students[i] == 0) {
                // 앞 번호 학생에게서 빌릴 수 있는지 확인
                if (i > 0 && students[i - 1] > 1) {
                    students[i]++;
                    students[i - 1]--;
                // 뒷 번호 학생에게서 빌릴 수 있는지 확인
                } else if (i < n - 1 && students[i + 1] > 1) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        // 체육수업을 들을 수 있는 학생 수 계산
        int answer = 0;
        for (int s : students) {
            if (s >= 1) answer++; // 체육복이 하나 이상 있으면 수업에 참여할 수 있음
        }
        
        return answer;
    }
}
