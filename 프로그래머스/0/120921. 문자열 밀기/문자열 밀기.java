class Solution {
    public int solution(String A, String B) {
        // A와 B의 길이가 같지 않으면 바로 -1 반환
        if (A.length() != B.length()) return -1;
        
        // A와 B가 이미 같은 경우, 밀 필요 없으므로 0 반환
        if (A.equals(B)) return 0;
        
        // 밀어야 하는 최소 횟수를 저장할 변수, 초기값은 -1 (밀어서 B가 될 수 없는 경우)
        int minShifts = -1;
        
        // A를 밀어서 B가 되는지 확인하기 위해 A의 길이만큼 반복
        for (int i = 1; i <= A.length(); i++) {
            // A의 문자열을 오른쪽으로 1칸씩 밀기
            String shifted = A.substring(A.length() - i) + A.substring(0, A.length() - i);
            
            // 밀어서 만든 문자열이 B와 같은지 확인
            if (shifted.equals(B)) {
                // 같다면 최소 횟수를 i로 설정하고 반복 종료
                minShifts = i;
                break;
            }
        }
        
        // 밀어서 B가 될 수 있는 최소 횟수 반환, 만약 불가능하다면 -1
        return minShifts;
    }
}
