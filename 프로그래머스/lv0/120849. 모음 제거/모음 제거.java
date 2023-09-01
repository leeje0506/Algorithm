class Solution {
    public String solution(String my_string) {
       char[] c=my_string.toCharArray();                                        //변수로 들어온 Stirng을 char배열로 변환
        String answer="";
        
        for(int i=0; i<my_string.length(); i++) {
            if(c[i]=='a' || c[i]=='e' || c[i]=='i' || c[i]=='o' || c[i]=='u') { //배열의 i번째 char가 모음이면
                answer+="";                                                     //삭제
            } else {                                                            //모음이 아니면
                answer+=c[i];                                                   //다시 배열에 넣음
            }
        }
        return answer;
    }
}
