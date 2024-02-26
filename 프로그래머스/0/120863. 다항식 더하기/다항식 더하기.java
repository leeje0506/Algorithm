class Solution {
    public String solution(String polynomial) {
        
        //변수 2개 : x합, 상수합
        int total_x = 0; //x합
        int total_num = 0; //상수합
        
        // +를 기준으로 split, x를 포함하고 있다면 x합, 아니라면 상수합에 더하기. 
        String [] tmps = polynomial.split(" \\+ ");
        
        for(String tmp : tmps){
            //x포함
            if(tmp.contains("x")){
                tmp = tmp.replace("x",""); //x를 제거한다.
                if(tmp.isEmpty()){ 
                    total_x += 1; //비었으면 x니까 1로 더함. 
                }else{
                    total_x += Integer.parseInt(tmp); //아니면 계수를 더함.
                }
            }
            //상수
            else {
                total_num += Integer.parseInt(tmp);
            }
        }
        
        // 결과 다항식 구성
        String answer = "";
        
        if (total_x > 0) {
            if (total_x > 1) answer += total_x + "x"; // x의 계수가 1보다 클 때
            else answer += "x"; // x의 계수가 1일 때
        }
        if (total_num > 0) {
            if (!answer.isEmpty()) answer += " + "; // 다항식에 이미 항이 있으면 + 추가
            answer += total_num;
        }

        return answer.isEmpty() ? "0" : answer; // 다항식이 비어있으면 "0" 반환
    }
}