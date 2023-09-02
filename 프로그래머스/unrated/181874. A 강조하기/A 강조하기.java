class Solution {
    public String solution(String myString) {
        String answer = "";
        
        String [] str = myString.split("");
        
        for(int i=0; i<str.length; i++){
            if(str[i].equals("a")){
                str[i] = str[i].toUpperCase();
            }else if(!(str[i].equals("A"))){
                str[i] = str[i].toLowerCase();
            }
        }
        
        for(int i=0; i<str.length; i++){
            answer += str[i];
        }
        return answer;
    }
}