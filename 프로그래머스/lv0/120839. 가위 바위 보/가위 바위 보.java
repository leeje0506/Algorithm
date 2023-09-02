class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        String [] str = rsp.split("");
        
        for(int i=0; i<str.length; i++){
            //가위 2 : 이기는 거 바위 0
            if(str[i].equals("2")){
                str[i] = "0";
            }
            //바위 0 : 이기는 거 보 5
            else if(str[i].equals("0")){
                str[i] = "5";
            }
            //보 5 : 이기는 거 가위 2
            else if(str[i].equals("5")){
                str[i] = "2";
            }
            answer += str[i];
        }
        
       
        return answer;
    }
}