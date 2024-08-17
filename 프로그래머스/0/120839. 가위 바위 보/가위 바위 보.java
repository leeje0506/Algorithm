class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        //가위 2, 바위 0, 보 5
        //바위 0, 보 5, 가위 2
        
        String[]result = rsp.split("");
        for(int i=0; i<result.length; i++){
            if(result[i].equals("2")){
                result[i] = "0";
            }else if(result[i].equals("0")){
                result[i] = "5";
            }else{
                result[i] = "2";
            }
        }
        
        answer = String.join("", result);
        
        
        return answer;
    }
}