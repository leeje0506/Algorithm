class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiou";  
        
        String[] result = my_string.split("");  // 입력 문자열을 문자 배열로 분리
        
        for (int i = 0; i < result.length; i++) {
            // 현재 문자가 모음 문자열에 포함되어 있지 않은 경우에만 StringBuilder에 추가
            if (!vowels.contains(result[i])) {
                sb.append(result[i]);
            }
        }
        
        return sb.toString(); 
    }
}
