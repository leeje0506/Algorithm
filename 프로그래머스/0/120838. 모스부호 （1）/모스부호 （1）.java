import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String letter) {
        // 모스 부호와 알파벳 간의 매핑 생성
        Map<String, String> morseMap = new HashMap<>();
        morseMap.put(".-", "a"); morseMap.put("-...", "b"); morseMap.put("-.-.", "c");
        morseMap.put("-..", "d"); morseMap.put(".", "e"); morseMap.put("..-.", "f");
        morseMap.put("--.", "g"); morseMap.put("....", "h"); morseMap.put("..", "i");
        morseMap.put(".---", "j"); morseMap.put("-.-", "k"); morseMap.put(".-..", "l");
        morseMap.put("--", "m"); morseMap.put("-.", "n"); morseMap.put("---", "o");
        morseMap.put(".--.", "p"); morseMap.put("--.-", "q"); morseMap.put(".-.", "r");
        morseMap.put("...", "s"); morseMap.put("-", "t"); morseMap.put("..-", "u");
        morseMap.put("...-", "v"); morseMap.put(".--", "w"); morseMap.put("-..-", "x");
        morseMap.put("-.--", "y"); morseMap.put("--..", "z");
        
        // 공백을 기준으로 모스 부호를 분리
        String[] morseCodes = letter.split(" ");
        StringBuilder result = new StringBuilder();
        
        // 각 모스 부호를 알파벳으로 변환하여 결과에 추가
        for (String morse : morseCodes) {
            result.append(morseMap.get(morse));
        }
        
        // 결과를 문자열로 반환
        return result.toString();
    }
}
