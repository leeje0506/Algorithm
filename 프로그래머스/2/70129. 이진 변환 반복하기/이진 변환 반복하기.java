class Solution {
    public int[] solution(String s) {
        int transformCount = 0; // 이진 변환 횟수
        int zeroCount = 0;      // 제거된 0의 총 개수

        while(!s.equals("1")){
            int originalLength = s.length();
            
            //0 제거
            s = s.replace("0", "");
            zeroCount += (originalLength - s.length());
            
            //2진수 변환
            int len = s.length();
            s = Integer.toBinaryString(len);
            
            transformCount++;
        }
        
        int [] answer = new int[]{transformCount, zeroCount};
        
        return answer;
    }
}