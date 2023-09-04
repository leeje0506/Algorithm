class Solution {
    public int solution(String number) {
        int answer = 0;
        int sum=0;
        
        String [] str = number.split("");
        
        for(int i=0; i<str.length; i++){
            sum += Integer.parseInt(str[i]);
        }
        
        answer = sum%9;
        return answer;
    }
}