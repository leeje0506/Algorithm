import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>(); // 중복 단어 체크를 위한 해쉬셋
        int person = 0; // 탈락자 번호
        int turn = 0; // 탈락 차례

        wordSet.add(words[0]); // 첫 단어는 먼저 추가

        for (int i = 1; i < words.length; i++) {
            // 끝말잇기 규칙을 어기거나 중복된 단어일 때
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || wordSet.contains(words[i])) {
                person = i % n + 1; // 사람 번호 계산
                turn = i / n + 1; // 차례 계산
                break; // 루프 종료
            }
            // 단어 해쉬셋에 추가
            wordSet.add(words[i]);
        }

        return new int[]{person, turn}; // 결과 반환
    }
}

