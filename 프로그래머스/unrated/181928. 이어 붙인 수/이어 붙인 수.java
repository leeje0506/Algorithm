class Solution {
    public int solution(int[] num_list) {
        int sumEven = 0;
        int sumOdd = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) { // 짝수
                sumEven = sumEven * 10 + num_list[i];
            } else { // 홀수
                sumOdd = sumOdd * 10 + num_list[i];
            }
        }
        
        int answer = sumEven + sumOdd;
        return answer;
    }
}
