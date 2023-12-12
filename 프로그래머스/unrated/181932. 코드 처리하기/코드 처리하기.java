class Solution {
    public String solution(String code) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();

        //코드 작성
        //초기 모드 0
        int mode = 0;
        int len = code.length();

        //앞에서부터 코드를 읽는다.
        for (int i = 0; i < len ; i++) {
            //mode : 0
            if(mode == 0){
                //code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가
                if(code.charAt(i) != '1' ) {
                    if (i % 2 == 0) { //짝수일 때,
                        sb.append(code.charAt(i));
                    }
                }
                //code[idx]가 "1"이면 mode를 0에서 1로 바꿈
                else{
                    mode = 1;
                }
            }
            //mode : 1
            else{
                //code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가
                if(code.charAt(i) != '1'){
                    if(i % 2 == 1) { //홀수일 때,
                        sb.append(code.charAt(i));
                    }
                }
                //code[idx]가 "1"이면 mode를 1에서 0로 바꿈
                else{
                    mode = 0;
                }
            }
        }

        //없으면 EMPTY
        if(sb.length() == 0){
            answer = "EMPTY";
            return answer;
        }
        else{
            answer = sb.toString();
            return answer;
        }
    }
}