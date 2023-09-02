class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        String str = myString.toUpperCase();
        String p = pat.toUpperCase();
        
        if(str.contains(p)){
            answer =1;
        }else{
            answer =0;
        }
        return answer;
    }
}