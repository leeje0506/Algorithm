class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ab = String.valueOf(a) + String.valueOf(b);
        
        int ab2 = (2*a*b);
        int abValue = Integer.parseInt(ab);
        
        if(abValue >= ab2) {
            return abValue;
        }else{
            return ab2;
        }
    }
}