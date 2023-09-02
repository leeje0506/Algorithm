class Solution {
    public String solution(String n_str) {
        int index = 0; // 0이 아닌 숫자가 처음 나오는 인덱스를 저장할 변수

        // 문자열을 왼쪽부터 탐색하면서 0이 아닌 숫자가 나올 때까지 인덱스를 증가시킴
        while (index < n_str.length() && n_str.charAt(index) == '0') {
            index++;
        }

        // 0이 아닌 숫자가 나온 이후의 문자열을 잘라서 반환
        return n_str.substring(index);
    }
}
