class Solution {
    public int solution(int M, int N) {
        // M x N 크기의 종이를 1 x 1 크기로 자르려면
        // 가로로 (M-1)번, 세로로 (N-1)번 잘라야 합니다.
        // 그런데 가로로 자른 후 세로를 자르면, 세로를 자를 때마다 가로에 대해 추가적인 잘라야 하는 횟수가 생깁니다. 
        // 따라서 각 가로마다 세로를 자르는 횟수인 N을 곱해줍니다.

        // 가로로 모두 자르고, 각 가로마다 세로를 자르는 횟수
        int answer = (M - 1) + M * (N - 1);
        
        return answer;
    }
}
