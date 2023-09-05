class Solution {
    public int solution(String my_string) {
        int sum = 0;

        int num = 0; // 현재 자연수를 구성
        boolean in = false; // 자연수 안에 있는지 여부

        // 문자열을 한 글자씩 순회
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if (Character.isDigit(c)) {
                // 현재 문자가 숫자인 경우 추가
                num = num * 10 + (c - '0');
                in = true;
            } else {
                // 현재 문자가 숫자x, 자연수면 합에 더하기
                if (in) {
                    sum += num;
                    num = 0; // 현재 자연수 초기화
                    in = false;
                }
            }
        }

        // 마지막으로 자연수가 끝나지 않고 문자열이 끝났을 경우 합산합니다.
        if (in) {
            sum += num;
        }

        return sum;
    }
}
