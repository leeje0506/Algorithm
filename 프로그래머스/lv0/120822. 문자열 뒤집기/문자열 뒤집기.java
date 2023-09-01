class Solution {
    public String solution(String my_string) {
        String answer = "";
        char [] str = my_string.toCharArray();
        char [] reverse = new char[str.length];
        
        for(int i=0; i<str.length; i++){
            reverse[i] = str[str.length -i -1];
            
        }
        answer = new String(reverse);
        return answer;
    }
}

// char 타입의 str 배열을 만들어 my_string을 char배열로 바꿔 값을 넣어줍니다. 
// char 타입의 reverse 배열을 만들어 str 길이만큼 배열 크기를 지정해줍니다.
// for문을 str 길이만큼 돌려 reverse의 i위치에 str의 마지막 배열 값을 넣어줍니다.
// reverse의 위치 'i'가 증가하고 str의 위치가 ' -i -1' 만큼 줄어드므로 배열이 거꾸로 담기게 됩니다.
// ** str[str.length -i -1]에서 -1을 해주는 이유는 배열이 0부터 시작하기 때문입니다.

