class Solution {
    public int solution(int a, int b) {
        int result_1 = 0;
        int result_2 = 0;
        
        result_2 = 2*a*b;
        
        String st_a_b = String.valueOf(a) + String.valueOf(b);
        result_1 = Integer.parseInt(st_a_b);
        
        int max = 0;
        max = Math.max(result_2, result_1);
        return max;
    }
}